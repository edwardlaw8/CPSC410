package CPSC410;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.JsonParser;


public class Fuser {
	
	@SuppressWarnings("rawtypes")
	ArrayList ViolationsAndPackages;
	@SuppressWarnings("rawtypes")
	ArrayList PackagesAndClasses;
	JsonParser parser;
	Gson gson;
	File file;
	File file2;
	FileWriter fw = null;
	String dir = System.getProperty("user.dir");
	
	public Fuser() {
	}
	
	@SuppressWarnings("unchecked")
	public void PMD_JD_fuse(int violations, JSONArray packageList, String repoName) {
		File jd_output_file;
		FileWriter fw = null;
		JSONObject fused_json = new JSONObject();
		try {
			JSONArray sorted_packages = creation_date_fuse(packageList, repoName);
			
			fused_json.put("violations", violations);
			fused_json.put("package_info", sorted_packages);
			
			jd_output_file = new File(dir + "/visualization/PMD_JD_fuse.json");
			fw = new FileWriter(jd_output_file);
			fw.write(fused_json.toString());
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			System.out.println("[PMD_JD_fuse]: JSON!!!");
			e.printStackTrace();
		}
	}

	public JSONArray creation_date_fuse(JSONArray packageList, String repoName) {
		
		FileReader creation_date_file;
		JSONArray sorted_packages = new JSONArray();
		try {
			
			if (repoName.equalsIgnoreCase("fm")) {
				creation_date_file = new FileReader(dir + "/custom-github-analyzer/packagesequence_musicbrainz.json");
			} else if (repoName.equalsIgnoreCase("spark")) {
				creation_date_file = new FileReader(dir + "/custom-github-analyzer/packagesequence.json");
			} else {
				throw new IllegalArgumentException();
			}
		
			BufferedReader reader = new BufferedReader(creation_date_file);
	
			JSONArray creation_date;
			StringBuilder string_builder = new StringBuilder();
			String reader_string  = "";
			
			while((reader_string = reader.readLine()) != null) {	
				string_builder.append(reader_string);
			}
			
			String json_string = string_builder.toString();
			
			creation_date_file.close();
			reader.close();
			
			JSONTokener json_tokener = new JSONTokener(json_string);
			creation_date = new JSONArray(json_tokener);
			
			for (int i = 0; i < creation_date.length(); i++) {
				
				JSONObject current_date_object = creation_date.getJSONObject(i);
				String current_package = current_date_object.getString("packagename");
				
				for (int j = 0; j < packageList.length(); j++) {
					JSONObject current_package_object = packageList.getJSONObject(j);
					if (current_package_object.getString("package-name").equals(current_package)) {
						JSONObject add_object = new JSONObject();
						add_object.put("package-name", current_package);
						add_object.put("create-date", current_date_object.getString("create-date"));
						add_object.put("number-of-class", current_package_object.getInt("number-of-class"));
						add_object.put("instability", current_package_object.getDouble("instability"));
						sorted_packages.put(add_object);
						break;
					}
				}
				
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return sorted_packages;
		
	}

}
