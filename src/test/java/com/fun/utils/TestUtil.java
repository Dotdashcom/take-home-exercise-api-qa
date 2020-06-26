package com.fun.utils;

import org.junit.Assert;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * Helper class for JSON manipulation
 */
public class TestUtil {

	public static int getResponseId(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonString).getAsJsonObject();
		return json.get("id").getAsInt();
	}
	
	public static Response getResponse(RequestSpecification request, String uri) {
		return request.when().get(uri);		
	}
	
	public static String getResponseContent(Response response) {
		ResponseBody responseBody = response.getBody();
		return responseBody.asString();
	}
	
       
    public static boolean isFibonacci(int n) 
    { 
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both 
        // is a perfect square 
        return isPerfectSquare(5*n*n + 4) || 
               isPerfectSquare(5*n*n - 4); 
    } 
    
    private static  boolean isPerfectSquare(int x) 
    { 
        int s = (int) Math.sqrt(x); 
        return (s*s == x); 
    } 

}
