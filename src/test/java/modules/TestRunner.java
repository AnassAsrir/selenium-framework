package modules;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                            "junit:target/cucumber-reports/Cucumber.xml",
                            "html:target/cucumber-reports"},
        features = {"src/test/resources/features"},
        glue = {"modules","step_definition"},
        tags = {""}
)

public class TestRunner {
    //Todo: create test run configuration
}
