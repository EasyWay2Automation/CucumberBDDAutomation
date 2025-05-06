package com.CucumberBDD.Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static PropertiesReader readProp = new PropertiesReader();

    public synchronized void setDriver(){
        WebDriver driver = BrowserUtility.createWebDriverInstance(readProp.getConfigProperties().getProperty("browserType"));
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public synchronized void removeDriver(){
       if(getDriver() != null) {
            getDriver().quit();
       }
        threadLocalDriver.remove();
    }
}
