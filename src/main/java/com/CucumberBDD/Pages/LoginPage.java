package com.CucumberBDD.Pages;

import com.CucumberBDD.Utilities.Constants;
import com.CucumberBDD.Utilities.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends DriverFactory {

	@FindBy(how=How.NAME, using="username")
	private WebElement username;
	
	@FindBy(how=How.NAME, using="password")
	private WebElement password; 

	@FindBy(how=How.XPATH, using="//button[normalize-space()='Login']")
	private WebElement loginBtn;
	
	@FindBy(how=How.XPATH, using="//img[@alt='company-branding']")
	private WebElement orangeHRMLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterUsername(String userID) {
		username.clear();
		username.sendKeys(userID);
	}
	
	
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}

	public void waitForLoginPageToLoad(){
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(username));
	}
	
	public boolean verifyOrangeHRMLogo() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(orangeHRMLogo));
		return orangeHRMLogo.isDisplayed();
	}

	public void loginWithValidCredentials() {
		waitForLoginPageToLoad();
		enterUsername(Constants.USERNAME);
		enterPassword(Constants.PASSWORD);
		clickOnLoginBtn();
	}
}
