package fun;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;


public class GameTests {


    String baseUrl = "http://localhost:8080/game";
    RestTemplate restTemplate = new RestTemplate();
    String request = "{\"id\":2584,\"text\":\"Playing Sudoku is fun!\"}";

    //Verify game POST endpoint is working
    @Test
    public void testPostGameEndPoint() {

        String postResponse = restTemplate.postForObject(baseUrl, request, String.class);
        Assert.assertEquals(true, postResponse.contains("Playing Sudoku is fun!"));

    }
    //Verify game GET endpoint is working
    @Test
    public void testGetGameEndPoint()
    {
        String getResponse = restTemplate.getForObject(baseUrl, String.class);
        Assert.assertEquals(true, getResponse.contains("Playing Sudoku is fun!"));

    }

    //Verify game PUT endpoint is working
    @Test
    public void testPutGameEndPoint()
    {
        restTemplate.put(baseUrl, String.class);

    }

    //Verify game DELETE endpoint is working
    @Test
    public void testDeleteGameEndPoint()
    {

        restTemplate.delete(baseUrl, String.class);


    }


}
