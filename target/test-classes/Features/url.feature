Feature: url Verification

@url
  Scenario: Validating the URL
    Given user is in Browser
    When user Enters the URL and Clicks on Search Button
    Then website is opened
