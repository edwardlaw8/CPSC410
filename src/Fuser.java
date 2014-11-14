import java.util.ArrayList;


public class Fuser {
	
	int PMDViolationsCount;
	
	public Fuser(int violations, ArrayList packageList) {
		ArrayList ViolationsAndPackages;
		ArrayList PackagesAndClasses;
		
		for (int i= 0; i < packageList.size(); i++){
			//Need to get package names and number of violations related to that package
			//and put them in a list together
			
			//Store Package to Class and then Package to Number of Violations
			
			String IndividualPackageName = packageList.get(i).getPackageName();
			ArrayList IndividualPackageClasses;
			if IndividualPackageName == violations.getPackageName(i) {
				ViolationsAndPackages.add(numberofViolations(i), i);
			IndividualPackageClasses.add(packageList.get(i).getClasses());
			}
					
			//convert ArrayList to JSONArray, then to JSON object to pass to Visualizer
		}
	}

}
