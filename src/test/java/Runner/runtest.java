package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/feature/ci.feature",glue = "steps")
public class runtest extends AbstractTestNGCucumberTests
{

}