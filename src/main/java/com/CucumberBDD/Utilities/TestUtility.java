package com.CucumberBDD.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtility extends DriverFactory {
    public static byte[] captureScreenshot() {
        TakesScreenshot srcShot = (TakesScreenshot) getDriver();
        return srcShot.getScreenshotAs(OutputType.BYTES);
    }


}
