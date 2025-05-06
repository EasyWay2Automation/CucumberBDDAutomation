package com.CucumberBDD.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(tags = "", features = "src/test/resources/features",
        glue = {"com.CucumberBDD.StepDefinitions","com.CucumberBDD.Hooks"},
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "junit:target/cucumber-report.xml",
                "json:target/cucumber-report.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
