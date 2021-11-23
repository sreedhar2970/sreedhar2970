Feature: Verifying Product page

  Background: login
    Given User is in Retail Website
    When clicks on User Icon button and Login/Register button inside
    Then Shows Login/Register page and user logins

  @sitemap
  Scenario: Verifying New product
    Given Navigates to home page by clicking on the home button
    When Navigates to sitemap page by clicking on sitemap button
    Then Clicks on sports button to navigate sports product page
    Then Search for the products
    Given Navigates to special offer page by clicking on special offer button
    Then It displays the special offer products
