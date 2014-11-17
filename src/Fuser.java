import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Fuser {
	
	ArrayList ViolationsAndPackages = null;
	ArrayList PackagesAndClasses = null;
	JsonObject JSONViolationsAndPackages;
	JsonObject JSONPackagesAndClasses;
	JsonParser parser;
	Gson gson;
	
	public Fuser(int violations, ArrayList packageList) {
		ViolationsAndPackages(violations, packageList);
		PackagesAndClasses(packageList);
	}
	
	public JsonObject ViolationsAndPackages(int violations, ArrayList packageList) {
		gson = new Gson();
		parser = new JsonParser();
		
		for (int i= 0; i < packageList.size(); i++){
			//Need to get package names and number of violations related to that package
			//and put them in a list together
			
			//Store Package to Number of Violations
			ViolationsAndPackages.add(violations, packageList.get(i));
			}
			
			JSONViolationsAndPackages = (JsonObject)parser.parse(gson.toJson(ViolationsAndPackages));
		
			//convert ArrayList to JSONArray, then to JSON object to pass to Visualizer
			return JSONViolationsAndPackages;
		}
	
	public JsonObject PackagesAndClasses(ArrayList packageList) {
		gson = new Gson();
		parser = new JsonParser();
		
		for (int i= 0; i < packageList.size(); i++){
			//Need to get package names and classes in that package
			//and put them in a list together
			
			//Store Package to Class
			PackagesAndClasses.add(packageList.get(i));
			
			}
			
			JSONPackagesAndClasses = (JsonObject)parser.parse(gson.toJson(PackagesAndClasses));
		
			//convert ArrayList to JSONArray, then to JSON object to pass to Visualizer
			return JSONPackagesAndClasses;
		}
	}

