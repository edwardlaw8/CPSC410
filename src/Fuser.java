import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.javatuples.Triplet;

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
	
	public Fuser(int violations, ArrayList packageList) {
		ViolationsAndPackages(violations, packageList);
		PackagesAndClasses(packageList);
	}
	
	@SuppressWarnings("unchecked")
	public void ViolationsAndPackages(int violations, ArrayList packageList) {
		gson = new Gson();
		try {
			file = new File("/Users/risanewyear-ramirez/git/CPSC410/visualization/ViolationsAndPackages.json");
			fw = new FileWriter(file);
			// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
						}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i= 0; i < packageList.size(); i++){
			//Need to get package names and number of violations related to that package
			//and put them in a list together
			
			//Store Package to Number of Violations
			ViolationsAndPackages.add(violations, packageList.get(i));
			}
			
			try {
				fw.write(gson.toJson(ViolationsAndPackages));
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@SuppressWarnings("unchecked")
	public void PackagesAndClasses(ArrayList packageList) {
		gson = new Gson();
		try {
			file2 = new File("/Users/risanewyear-ramirez/git/CPSC410/visualization/PackagesAndClasses.json");
			fw = new FileWriter(file2);
			// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
						}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i= 0; i < packageList.size(); i++){
			//Need to get package names and classes in that package
			//and put them in a list together
			
			//Store Package to Class
			PackagesAndClasses.add(packageList.get(i));
			
			}
			
		try {
			fw.write(gson.toJson(PackagesAndClasses));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

