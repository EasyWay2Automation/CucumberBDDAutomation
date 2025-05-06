package com.CucumberBDD.StepDefinitions;

import com.CucumberBDD.Pages.DashboardPage;
import com.CucumberBDD.Pages.LoginPage;
import com.CucumberBDD.Utilities.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class OrangeHRMStepDef extends DriverFactory {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("User invokes Orange HRM Application")
    public void invokeApplication() {
        getDriver().get(readProp.getConfigProperties().getProperty("appURL"));
        loginPage.waitForLoginPageToLoad();
    }

    @Then("Orange HRM Logo should be displayed")
    public void verifyOrangeHRMLogoOnLoginPage() {
        Assert.assertTrue(loginPage.verifyOrangeHRMLogo(), "Orange HRM Logo is not displayed");
    }
    @When("User logins to Orange HRM Application")
    public void loginToOrangeHRMApp(){
        loginPage.waitForLoginPageToLoad();
        loginPage.loginWithValidCredentials();
        dashboardPage.waitForDashboardPageToLoad();
    }

    @Then("Following links should be displayed on the home page")
    public void userVerifiesNavigationLinks(DataTable dataTable) {
        List<String> data = dataTable.asList();
        List<String> expNavigationLinkTexts = new ArrayList<>();
        for (String datum : data) {
            expNavigationLinkTexts.add(datum.trim());
        }
        dashboardPage.verifyNavigationLinks(expNavigationLinkTexts);
    }

    @And("User logs out of the application")
    public void logOutOfOrangeHRMApp(){
        dashboardPage.verifyLogOutLink();
        dashboardPage.clickOnLogOut();
        loginPage.waitForLoginPageToLoad();
    }

    @Then("Navigation Panel should have been expanded")
    public void verifyExpandedNavigationPanel(){
        Assert.assertTrue(dashboardPage.fetchClassAttributeOfChevron().contains("left"));
    }

    @When("User clicks on Collapse chevron")
    public void clickOnCollapseChevron(){
        dashboardPage.clickOnExpandAndCollapseBtn();
    }

    @Then("Navigation Panel should be collapsed")
    public void verifyCollapsedNavigationPanel(){
        Assert.assertTrue(dashboardPage.fetchClassAttributeOfChevron().contains("right"));
    }
}
