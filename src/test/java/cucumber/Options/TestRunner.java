package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features"
                ,plugin="json:target/cucumberreports/jsonreport.json"
                 ,glue= "stepDefintions")
             //    tags= "@AddPlace")
public class TestRunner {

}
