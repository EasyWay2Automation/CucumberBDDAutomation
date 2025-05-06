package com.CucumberBDD.Hooks;

import com.CucumberBDD.Utilities.DriverFactory;
import com.CucumberBDD.Utilities.TestUtility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks extends DriverFactory {

    @Before
    public void beforeScenario() {
        setDriver();
    }

    @After
    public void afterScenario() {
        removeDriver();
    }
    @AfterStep
    public void afterTestStep(Scenario sc){
        sc.attach(TestUtility.captureScreenshot(), "image/png", "screenshot attached");
    }
}
