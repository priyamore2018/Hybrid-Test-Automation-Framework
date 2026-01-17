package org.qabrains.runner.qa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/ecommercesite.feature"},
		glue = {"org.qabrains.stepdefination.qa","org.qabrains.hooks.qa"},
		plugin = {"pretty","html:target/cucumber-reports/cucumber.html","json:target/cucumber-reports/cucumber.json"}
		)
public class EcommerceTestRunner extends AbstractTestNGCucumberTests{

}
