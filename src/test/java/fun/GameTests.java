package fun;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import org.junit.Test;



public class GameTests {
	
	
			
	@Test
	//checking for chess
	public void getgame() {
		RestAssured.baseURI= "http://localhost:8080/";
		String inputgame="Chess";
		String response=given().log().all().queryParam("name", inputgame).header("Content-Type","application/json")
				.when().get("/game").then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath jp=new JsonPath(response);
		String gamename=jp.getString("text");
		System.out.println(gamename);
		assertTrue(gamename.contains(inputgame));
		
		int fibid=jp.getInt("id");
		checkfibonacci cf=new checkfibonacci();
		//System.out.println(fibid);
		System.out.println(cf.fibonacci(fibid));
	}
	
	
	@Test
	//checking for numeric name
	public void getgamenumeric() {
		RestAssured.baseURI= "http://localhost:8080/";
		String inputgame="1235";
		String response=given().log().all().queryParam("name", inputgame).header("Content-Type","application/json")
				.when().get("/game").then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath jp=new JsonPath(response);
		String gamename=jp.getString("text");
		System.out.println(gamename);
		assertTrue(gamename.contains(inputgame));
		int fibid=jp.getInt("id");
		checkfibonacci cf=new checkfibonacci();
		//System.out.println(fibid);
		System.out.println(cf.fibonacci(fibid));
	}
	@Test
	//checking for sudoku
	public void getgamesudoku() {
		RestAssured.baseURI= "http://localhost:8080/";
		String response=given().log().all().header("Content-Type","application/json")
				.when().get("/game").then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath jp=new JsonPath(response);
		String gamename=jp.getString("text");
		System.out.println(gamename);
		assertTrue(gamename.contains("Sudoku"));
		int fibid=jp.getInt("id");
		checkfibonacci cf=new checkfibonacci();
		//System.out.println(fibid);
		System.out.println(cf.fibonacci(fibid));
	}
	

}



