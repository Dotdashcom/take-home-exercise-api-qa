package fun;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class GameTests {
    //    public static void main(String[] args) throws IOException {
//    URL url = new URL("http://localhost:8080/game?name=Chess");
//    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//    }
    String baseUrl = "http://localhost:8080";
    @Test
    @DisplayName("If there is no query parameter then the game endpoint by default sets game to Sudoku")
    public void test1() {
        Response response = given().accept(ContentType.JSON).
                                    get(baseUrl + "/game").prettyPeek();
                    response.then().assertThat().statusCode(200).
                                    contentType(ContentType.JSON).
                                    assertThat().body("text", is("Playing Sudoku is fun!"));
        int id = response.jsonPath().getInt("id");
        Assert.assertNotEquals(224, id);//I used notEqual because of the fibonacci sequence
    }
    @Test
    @DisplayName("Verify that if there is no parameter")
    public void test2() {

        Response response = given().accept(ContentType.JSON).
                get(baseUrl ).prettyPeek();
        response.then().assertThat().statusCode(404).
                        contentType(ContentType.JSON).
                        assertThat().body("status", is(404)).
                        assertThat().body("error",is("Not Found")).
                        assertThat().body("message",is("No message available")).
                        assertThat().body("path",is("/"));
    }
    @Test
    @DisplayName("with invalid query param")
    public void test3() {
        Response response = given().accept(ContentType.JSON).
                                    queryParam("name", "Chess").
                                    get(baseUrl + "/game").prettyPeek();
                    response.then().assertThat().statusCode(200).
                                    assertThat().contentType(ContentType.JSON).
                                    assertThat().body("text",is("Playing Chess is fun!"));
        int id = response.jsonPath().getInt("id");
        Assert.assertNotEquals(28657, id);//I used notEqual because of the fibonacci sequence
        //       The Fibonacci sequence: Each number in the sequence is the sum of the two numbers that precede it .
    }
    @Test
    @DisplayName("service returns an id and text for a game that is requested in the 'name' query parameter")
    public void test4() {
        Response response = given().accept(ContentType.JSON).
                                    queryParam("na", "Chess").
                                    get(baseUrl + "/game").prettyPeek();
                    response.then().assertThat().statusCode(200).
                                    assertThat().contentType(ContentType.JSON).
                                    assertThat().body("text", is("Playing Sudoku is fun!"));
        int id = response.jsonPath().getInt("id");
        Assert.assertNotEquals(121393, id);//I used notEqual because of the fibonacci sequence
//      I was expecting error message after a wrong query param however I received the message just as in the no query param.
//      Is this considered as a bug.
    }
}
