package fun;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/fun", glue = {
							"com.fun.steps" }, 
							dryRun = true, 
							tags = "@DefaultGameTest, @NamedGameTest")
public class GameTests {

}
