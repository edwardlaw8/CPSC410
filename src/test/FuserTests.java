package test;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import CPSC410.Fuser;

public class FuserTests {
	
	JSONObject testMBObj = new JSONObject();	
	JSONArray testMBArray = new JSONArray();
	
	JSONObject testSparkObj = new JSONObject();	
	JSONArray testSparkArray = new JSONArray();
	
	@Before
	public void initializeObjects() {
		try {
			testMBObj.put("number-of-class", 5);
			testMBObj.put("instability", 0.75);
			testMBObj.put("package-name", "fm.last.musicbrainz.data.dao");
			testMBArray.put(testMBObj);
			
			testMBObj = new JSONObject();
			testMBObj.put("number-of-class", 2);
			testMBObj.put("instability", 1.33);
			testMBObj.put("package-name", "fm.last.musicbrainz.data.hibernate");
			testMBArray.put(testMBObj);
			
			testSparkObj.put("number-of-class", 5);
			testSparkObj.put("instability", 0.75);
			testSparkObj.put("package-name", "spark");
			testSparkArray.put(testSparkObj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testMBFuse() {
		Fuser testFuser = new Fuser();
		JSONArray testArray = testFuser.creation_date_fuse(testMBArray, "fm");
		assertEquals(testArray.length(), 2);
		
		JSONArray testArray2 = testFuser.creation_date_fuse(testMBArray, "spark");
		assertEquals(testArray2.length(), 0);
	}
	
	@Test
	public void testSparkFuse() {
		Fuser testFuser = new Fuser();
		JSONArray testArray = testFuser.creation_date_fuse(testSparkArray, "fm");
		assertEquals(testArray.length(), 0);
		
		JSONArray testArray2 = testFuser.creation_date_fuse(testSparkArray, "spark");
		assertEquals(testArray2.length(), 1);
	}

}
