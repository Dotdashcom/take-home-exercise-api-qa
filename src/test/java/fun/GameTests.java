package fun;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GameTests extends FunctionalTest{

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    //Verify the service is up and running
    public void pingTest(){
        Response response =  given().when().get();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    //Verify if the service returns the default game
    public void defaultGameTest(){
        String defaultResponse =  given().when().get().then().extract().asString();
        String defaultText = null;
        try {
            JsonNode dfltRsp = mapper.readTree(defaultResponse);
            defaultText = dfltRsp.get("text").asText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(defaultResponse != null);
        Assert.assertEquals(defaultText,"Playing Sudoku is fun!");
    }

    @Test
    //Verify that input game is returned back
    public void inputGameTest(){
        String inputGameResponse =  given().queryParam("name", "Chess").when().get().then().extract().asString();
        String inputGameText = null;
        try {
            JsonNode dfltRsp = mapper.readTree(inputGameResponse);
            inputGameText = dfltRsp.get("text").asText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(inputGameResponse != null);
        Assert.assertEquals(inputGameText,"Playing Chess is fun!");
    }

    @Test
    //Verify If game Id isn't 0
    public void inputGameIdTest(){
        String inputGameResponse =  given().queryParam("name", "Chess").when().get().then().extract().asString();
        int inputGameId = 0;
        try {
            JsonNode dfltRsp = mapper.readTree(inputGameResponse);
            inputGameId = dfltRsp.get("id").asInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(inputGameResponse != null);
        Assert.assertTrue(inputGameId != 0);
    }


    @Test
    //Verify the service doesn't return a duplicated Id.
    public void inputGameDifferentIdTest(){
        String inputGameResponse =  given().queryParam("name", "Chess").when().get().then().extract().asString();
        String secondInputGameResponse =  given().queryParam("name", "Soccer").when().get().then().extract().asString();
        int inputGameId = 0;
        int secondInputGameId = 0;
        try {
            JsonNode dfltRsp = mapper.readTree(inputGameResponse);
            inputGameId = dfltRsp.get("id").asInt();

            JsonNode dfltRsp2 = mapper.readTree(secondInputGameResponse);
            secondInputGameId = dfltRsp2.get("id").asInt();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(inputGameId != secondInputGameId);
    }

}
