@Usericon
Feature: Verifying User Icon

  Scenario: Response of User Icon user clicks on it
    Given User is in Retail Website
    When clicks on User Icon button and Login/Register button inside
    Then Shows Login/Register page and user logins
    And Clicks on my orders page and comes back
    Then Clicks on logout
  
