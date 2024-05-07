package com.CucumberBDD.Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static PropertiesReader readProp = new PropertiesReader();

    public void setDriver(){
        WebDriver driver = BrowserUtility.createDriverInstance(readProp.getConfigProperties().getProperty("browserType"));
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public void removeDriver(){
       if(getDriver() != null) {
            getDriver().quit();
       }
        threadLocalDriver.remove();
    }
}
