package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features/",glue="co.test.stepDefinitions",
monochrome=true, tags = "@Regression", plugin= {"html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
}
