package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fun.GameTests;
import org.testng.Assert;

/**
 * Created by Gia Pachkhatashvili
 */
public class gameSD {
    GameTests gameTests = new GameTests();

    @When("^I enter (.+) test$")
    public void enterGameName(String gameName){

        gameTests.gameTest(gameName);
    }

    @Then("^I verify text$")
    public void verifyText(){
        System.out.println(gameTests.getResultTest());
        Assert.assertEquals(gameTests.getResultTest(),gameTests.expectedText);
    }

    @When("^I Test blank text$")
    public void enterBlank(){

        gameTests.gameTest(" ");
    }

    @When("^I Test Failure text$")
    public void testFailureText(){
        gameTests.gameTest("Failure");
    }

    @Then("^I verify Failure text$")
    public void verifyFailureText(){
        System.out.println(gameTests.getResultTest());
        Assert.assertNotEquals(gameTests.getResultTest(), "Playing (Failure text) is fun!");
    }

    @When("I verify enter ID (.+) times")
    public void checkID(String number){
        Assert.assertTrue(gameTests.checkID(number));
    }
}
