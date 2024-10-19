package cucumber.Options;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)  //To instruct to perform execution using JUNIT
@CucumberOptions(features="src/test/java/features", glue= {"stepDefinations"}) //To instruct the TestRunner where the features and step definitions are present
public class TestRunner {
	

}
