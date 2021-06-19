package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.*;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src\\test\\java\\features",
		glue= "definition",
		tags= {"@Login"},
		dryRun=false,
		strict=true)



public class TestRunner extends AbstractTestNGCucumberTests
{

}
