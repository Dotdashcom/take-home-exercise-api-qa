package fun;
import static fun.Utilities.*;
import static fun.DateTimeUtilities.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GameTests {

    @BeforeAll
    public static void setup(){

        baseURI = "http://localhost:8080/game";

    }
    /**
     * Tasks:
     * Come up with functional tests for the application.
     * Write tests/assertions in your favorite programming language.
     * Open a pull request for code review.
     *
     */

    // Non parameter verification test for field values
    @Test
    @DisplayName("No parameter test")
    public void noParams(){


        Response response = given().get().prettyPeek();

        response.then().
                assertThat().
                statusCode(200).
                and().
                contentType("application/json; charset=utf-8").
                and().
                contentType("application/json; charset=utf-8").
                header("Transfer-Encoding", is("chunked")).
                header("Date", is(getCurrentDateAndTime())).
                body("id", notNullValue()).
                body("text", notNullValue());
        Assert.assertTrue(response.jsonPath().get("id") instanceof Integer);
        Assert.assertTrue(response.jsonPath().get("text") instanceof String);

    }

    @Test
    @DisplayName("No parameter test for default response")
    public void noParams2(){
        Response response = given().contentType(ContentType.JSON).
                when().
                    get().prettyPeek();

        response.then().
                assertThat().
                statusCode(200).
                and().
                contentType("application/json; charset=utf-8").
                header("Transfer-Encoding", is("chunked")).
                header("Date", is(getCurrentDateAndTime())).
                body("text", is("Playing Sudoku is fun!"));

        int id = response.jsonPath().get("id");
        Assert.assertTrue(isFibonacci(id));


    }
      //Testing with the name as query parameter
    @Test
    @DisplayName("Game Name test")
    public void gameNameTest(){
        String gameName = "Chess";

        Response response =
                given().
                queryParams("name", gameName).
                 when().
                 get().prettyPeek();

        response.then().
                assertThat().
                statusCode(200).
                and().
                contentType("application/json; charset=utf-8").
                and().
                contentType("application/json; charset=utf-8").
                header("Transfer-Encoding", is("chunked")).
                header("Date", is(getCurrentDateAndTime())).
                body("text",is("Playing " + gameName + " is fun!"));

    }

}
