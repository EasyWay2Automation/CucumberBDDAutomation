package com.CucumberBDD.Pages;

import com.CucumberBDD.Utilities.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends DriverFactory {

	@FindBy(how=How.XPATH, using="//ul[@class='oxd-main-menu']/child::li/child::a/descendant::span")
	private List<WebElement> navigationLinks;
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Search']/following-sibling::button")
	private WebElement expand_collapse_Btn;
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Search']/following-sibling::button/child::i")
	private WebElement exp_collapse_chevron;
	
	@FindBy(how=How.XPATH, using="//li[@class='oxd-userdropdown']")
	private WebElement userDropdown;

	@FindBy(how=How.LINK_TEXT, using="Logout")
	private WebElement logout;
	
	public void waitForDashboardPageToLoad(){
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(expand_collapse_Btn));
	}
	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean verifyNavigationLinks(List<String> expNavigationLinkTexts) {
		List<String> actNavigationLinkTexts = new ArrayList<>();
		for(WebElement l1: navigationLinks) {
			actNavigationLinkTexts.add(l1.getText());
		}
		
		
		return actNavigationLinkTexts.equals(expNavigationLinkTexts);
	}
	
	public void clickOnExpandAndCollapseBtn() {
		expand_collapse_Btn.click();
	}
	
	public String fetchClassAttributeOfChevron() {
		return exp_collapse_chevron.getDomAttribute("class");
	}
	
	public boolean verifyLogOutLink() {
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", userDropdown);*/
		userDropdown.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(logout));
		return logout.isDisplayed();
	}
	
	
	public void clickOnLogOut() {
		logout.click();
	}
}
