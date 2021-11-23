Feature: Navigation buttons

  @socialicons
  Scenario: verify the functionality of social icons
    Given The user goes to the site
    When The user scrolls down
    And The user clicks on the social icon
    Then The user should navigate to the respective social media

  @navigatebtn
  Scenario: navigate buttons
    Given Customer opens the site scrools down
    When Test the functionality of navigate buttons
    Then come back to main page
