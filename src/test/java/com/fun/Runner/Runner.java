package com.fun.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/fun", glue = {
							"fun" }, 
							dryRun = false, 
							tags = "@DefaultGameTest, @NamedGameTest")

public class Runner {

}
