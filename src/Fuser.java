import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class Fuser {
	
	JsonObject JSONViolationsAndPackages;
	JsonObject JSONPackagesAndClasses;
	
	public Fuser(int violations, ArrayList packageList) {
		ViolationsAndPackages(violations, packageList);
		PackagesAndClasses(packageList);
	}
	
	public JsonObject ViolationsAndPackages(int violations, ArrayList packageList) {
		ArrayList ViolationsAndPackages;
		Gson gson = new Gson();
		
		for (int i= 0; i < packageList.size(); i++){
			//Need to get package names and number of violations related to that package
			//and put them in a list together
			
			//Store Package to Number of Violations
			
			String IndividualPackageName = packageList.get(i).getPackageName();
			ViolationsAndPackages.add(violations, IndividualPackageName);
			}
			
			JSONViolationsAndPackages = gson.toJson(ViolationsAndPackages);
		
			//convert ArrayList to JSONArray, then to JSON object to pass to Visualizer
			return JSONViolationsAndPackages;
		}
	
	public JsonObject PackagesAndClasses(ArrayList packageList) {
		ArrayList PackagesAndClasses;
		Gson gson = new Gson();
		
		for (int i= 0; i < packageList.size(); i++){
			//Need to get package names and classes in that package
			//and put them in a list together
			
			//Store Package to Class
			
			String IndividualPackageName = packageList.get(i).getPackageName();
			int IndividualPackageClasses;
			IndividualPackageClasses = packageList.get(i).getNumberOfClasses();
			
			PackagesAndClasses.add(IndividualPackageClasses, packageList.get(i));
			
			}
			
			JSONPackagesAndClasses = gson.toJson(PackagesAndClasses);
		
			//convert ArrayList to JSONArray, then to JSON object to pass to Visualizer
			return JSONPackagesAndClasses;
		}
	}

