package com.fun.steps;

import static io.restassured.RestAssured.given;
import org.junit.Assert;

import com.fun.utils.GameConstantsAPI;
import com.fun.utils.TestUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * This step definition validates the default behavior of the Game API.
 */
public class GetDefaultName {
	private RequestSpecification request;
	private Response response;
	private int id;
	private String responseContent;
	
	@Given("user sets the API header")
	public void user_sets_the_API_header() {
		request=given().header("Content-Type","application/json");
	}
	@Given("user retrieves a game")
	public void user_retrieves_a_game() {
		response=TestUtil.getResponse(request, GameConstantsAPI.DEFAULT_API_URI);
	}
	@Given("HTTP status code is {int} for the API response")
	public void http_status_code_is_for_the_API_response(int statusCode) {
		response=TestUtil.getResponse(request, GameConstantsAPI.DEFAULT_API_URI);
		responseContent = TestUtil.getResponseContent(response);
		response.then().assertThat().statusCode(statusCode);
	}
	@Given("user validates the returned id is an integer")
	public void user_validates_the_returned_id_is_an_integer() {
		int id = TestUtil.getResponseId(responseContent);
		Assert.assertTrue(Integer.class.isInstance(id));
	}

	@Given("user validates id is present")
	public void user_validates_id_is_present() {
		Assert.assertTrue(responseContent.contains("id"));
	    
	}

	@Given("user validates text is present")
	public void user_validates_text_is_present() {
		Assert.assertTrue(responseContent.contains("text"));	    
	}
	
	@Then("user validates text equals to {string}")
	public void user_validates_text_equals_to(String defaultText)  {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String text = jsonPathEvaluator.get("text");
		Assert.assertEquals(text, defaultText);
	}

	@When("request is sent the id is incremented")
	public void request_has_sent_the_id_is_increamented() {
		int firstId = TestUtil.getResponseId(responseContent);
		response=TestUtil.getResponse(request, GameConstantsAPI.DEFAULT_API_URI);
		responseContent = TestUtil.getResponseContent(response);
		int secondId = TestUtil.getResponseId(responseContent);
		Assert.assertTrue(secondId > firstId);
	} 
}
