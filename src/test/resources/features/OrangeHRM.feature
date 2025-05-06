Feature: Google Search

  Background:

    Given User invokes Orange HRM Application

  Scenario: To Verify Orange HRM Logo on the the login page
    Then Orange HRM Logo should be displayed

  Scenario: To verify navigation links displayed on the home page
    When User logins to Orange HRM Application
    Then Following links should be displayed on the home page
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |
    And User logs out of the application

  Scenario: To verify the functionality of expand and collapse chevron
    When User logins to Orange HRM Application
    Then Navigation Panel should have been expanded
    When User clicks on Collapse chevron
    Then Navigation Panel should be collapsed
    And User logs out of the application

