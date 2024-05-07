Feature: Google Search

  Background:

    Given User invokes Google Search Application

  Scenario: To verify search functionality on google search Page

    When User enters "Selenium" in the search edit box
    And User clicks on search button
    Then Search result should be displayed successfully

  Scenario: To verify that links: About, Store, Gmail, Images are displayed on google search page

    Then Following links should be displayed on google search page
      | About  |
      | Store  |
      | Gmail  |
      | Images |