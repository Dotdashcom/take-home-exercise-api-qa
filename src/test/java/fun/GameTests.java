package fun;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class GameTests {
	
	private String url = "http://localhost:8080/game";
	Response response = RestAssured.get(url);
	private String gameToValidate = "";
	
	@Test
	void test_01_verifyStatusCode() {
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);	
	}
	
	@Test
	void test_02_verifyIdFieldExist() {
		Assert.assertTrue(response.getBody().asString().contains("id"));

	}
	@Test
	void test_03_veifyTextFieldExist() {
		
		
		Assert.assertTrue(response.getBody().asString().contains("text"));

	}
	@Test
	void test_04_verifyTextContent() throws JSONException {
		 gameToValidate = "Sudoku";	 
		 JSONObject json = new JSONObject(response.getBody().asString().toString());
		 Assert.assertTrue(json.get("text").equals("Playing " + gameToValidate + " is fun!"));	

	}
	@Test
	void test_05_verifyCustomTextContent() throws JSONException {
		 gameToValidate = "Sudoku5555";	
		 response = RestAssured.get(url + "?name=" + gameToValidate);		  
		 JSONObject json = new JSONObject(response.getBody().asString().toString());
		 Assert.assertTrue(json.get("text").equals("Playing " + gameToValidate + " is fun!"));
	
	}
	
	@Test
	void test_066_verifyIdGreatherThan0() throws JSONException {		  
		 String num;
		 JSONObject json = new JSONObject(response.getBody().asString().toString());
		 num = json.getString("id");
		 int id = Integer.parseInt(num);
		 Assert.assertTrue((id > 0) ? true : false);
	}
	
	
}
