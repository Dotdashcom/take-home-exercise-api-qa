package fun;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTests {

    private String endpoint = "http://localhost:8080/game";
    private String GAME_NAME_PARAM = "name";
    private String EXPECTED_RESPONSE = "Playing %s is fun!";

    @Test()
    public void test_01(){
        Response response = RestAssured.given().queryParam(GAME_NAME_PARAM,"Poker").get(endpoint);
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    public void test_02(){
        Response response = RestAssured.given().queryParam(GAME_NAME_PARAM,"Poker").get(endpoint);
        assertThat(response.getBody().asString()).contains("id").contains("text");
    }

    @Test
    public void test_03(){
        Response response = RestAssured.given().queryParam(GAME_NAME_PARAM,"Poker").get(endpoint);
        Game gameResponse = response.getBody().as(Game.class);
        assertThat(gameResponse.getText()).isEqualTo(String.format(EXPECTED_RESPONSE, "Poker"));
    }

    @Test
    public void test_04(){
        Response response = RestAssured.given().queryParam(GAME_NAME_PARAM,"Poker").get(endpoint);
        Game gameResponse = response.getBody().as(Game.class);
        int firstId = gameResponse.getId();

        response = RestAssured.given().queryParam(GAME_NAME_PARAM,"Chess").get(endpoint);
        gameResponse = response.getBody().as(Game.class);
        int newId = gameResponse.getId();

        assertThat(newId).isGreaterThan(firstId);
    }

    @Test
    public void test_05(){
        Response response = RestAssured.given().get(endpoint);
        Game gameResponse = response.getBody().as(Game.class);
        assertThat(gameResponse.getText()).isEqualTo(String.format(EXPECTED_RESPONSE, "Sudoku"));
    }

    @Test
    public void test_06(){
        Response response = RestAssured.given().queryParam("invalid_param","Chess").get(endpoint);
        assertThat(response.getStatusCode()).isEqualTo(400);
    }
}