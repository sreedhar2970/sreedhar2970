Feature: url Verification

@url
  Scenario: Validating the URL
    Given user is in Browser
    When user Enters the URL
    Then website is opened
