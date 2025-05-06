package com.CucumberBDD.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserUtility {
    static WebDriver driver;

    /**
     * To return WebDriver reference variable by assigning object to it based on the browser type
     * @param browser String
     * @return  driver  WebDriver
     */
    public static WebDriver createWebDriverInstance(String browser){
        switch (browser.toUpperCase()) {
            case "CHROME" -> driver = new ChromeDriver();
            case "EDGE" -> driver = new EdgeDriver();
            case "FIREFOX" -> driver = new FirefoxDriver();
            default -> {
                System.out.println("Please validate your browser : " + browser);
                System.exit(0);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.TIMEOUT));
        return driver;
    }
}
