package com.CucumberBDD.StepDefinitions;

import com.CucumberBDD.Pages.GoogleSearchPage;
import com.CucumberBDD.Utilities.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class GoogleSearchStepDef extends DriverFactory {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("User invokes Google Search Application")
    public void invokeApplication() {
        getDriver().get(readProp.getConfigProperties().getProperty("appURL"));
    }

    @When("User enters {string} in the search edit box")
    public void userEntersSearchText(String txtToBeSearched) {
        googleSearchPage.enterValueInSearchEdit(txtToBeSearched);
    }

    @And("User clicks on search button")
    public void userClicksOnSearchBtn() {
        googleSearchPage.clickOnSearchBtn();
    }

    @Then("Search result should be displayed successfully")
    public void userVerifiesSearchResult() {
        Assert.assertTrue(googleSearchPage.verifySearchResult());
    }

    @Then("Following links should be displayed on google search page")
    public void userVerifiesHeaderLinks(DataTable dataTable) {
        List<String> data = dataTable.asList();
        for (String datum : data) {
            Assert.assertTrue(googleSearchPage.verifyLinkPresent(datum.trim()));
        }

    }
}
