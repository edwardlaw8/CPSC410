import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	public void PMD_JD_fuse(int violations, JSONArray packageList) {
		File jd_output_file;
		FileWriter fw = null;
		JSONObject fused_json = new JSONObject();
		try {
			fused_json.put("violations", violations);
			fused_json.put("package_info", packageList);
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

}