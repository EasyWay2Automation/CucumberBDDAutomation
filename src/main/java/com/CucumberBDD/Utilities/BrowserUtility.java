package com.CucumberBDD.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserUtility {
    static WebDriver driver;

    /**
     * To return WebDriver reference variable by assigning object to it based on the browser type
     * @param browser String
     * @return  driver  WebDriver
     */
    public static WebDriver createDriverInstance(String browser){

        if(browser.equalsIgnoreCase("CHROME")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("MS EDGE")) {
            driver = new EdgeDriver();
        }
        // Maximize Browser Window
        driver.manage().window().maximize();

        return driver;
    }
}
