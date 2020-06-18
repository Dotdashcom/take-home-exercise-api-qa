package fun;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		// This creates cucumber reports
        plugin = {"pretty", "html:target/site/cucumber-pretty"},
        //This create auto method name in camelCase
        snippets = cucumber.api.SnippetType.CAMELCASE,
        
        //Path to your feature file
        features = {"src/test/resources/"},
        // Specify tags to be executed
        tags = {"@functional"},
        //Specify step definition package name (Note : make sure to have this package on current directory)
        glue = {"stepdefinition"}
)
public class TestRunner {
	
}
