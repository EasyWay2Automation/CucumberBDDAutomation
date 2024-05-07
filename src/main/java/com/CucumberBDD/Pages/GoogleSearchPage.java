package com.CucumberBDD.Pages;

import com.CucumberBDD.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends DriverFactory {

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchEdit;

    @FindBy(how = How.XPATH, using = "//textarea[@name='q']/ancestor::div[3]/following-sibling::div[3]/descendant::input[@name='btnK']")
    private WebElement searchBtn;

    @FindBy(how = How.XPATH, using = "//h3[text()='Selenium']/parent::a[contains(@href,'www.selenium.dev')]")
    private WebElement searchResult;

    public GoogleSearchPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void enterValueInSearchEdit(String txtToBeSearched){
        searchEdit.clear();
        searchEdit.sendKeys(txtToBeSearched);
    }

    public void clickOnSearchBtn(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", searchBtn);
    }

    public boolean verifySearchResult(){
        return searchResult.isDisplayed();
    }

    public boolean verifyLinkPresent(String linkText){
        return getDriver().findElement(By.linkText(linkText)).isDisplayed();
    }

}
