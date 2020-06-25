package com.fun.steps;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import com.fun.utils.GameConstantsAPI;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * This step definition validates the API when the query parameter "name" is sent in the request.
 */

public class GetGameName {
	private RequestSpecification request;
	private Response response;
	
	@When("user passes game name parameter as {string}")
	public void user_passes_game_name_parameter_as(String gameName) {
		request=given().header("Content-Type","application/json");
		response=request.when().get(GameConstantsAPI.PARAMETRIZED_API_URI + gameName);
	}
	
	@Then("user validates that the response text reads {string}")
	public void user_validates_that_the_response_text_reads(String defaultGame) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String text = jsonPathEvaluator.get("text");
		Assert.assertEquals(text, defaultGame);
	}
}
