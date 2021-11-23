Feature: Verifying Product page

  Background: login
   Given The user navigated to "http://retailm1.upskills.in/"
    When Enters "rahulpadma321@gmail.com" and "Reddy@108"

  @sitemap
  Scenario: Verifying New product
    Given Navigates to home page by clicking on the home button
    When Navigates to sitemap page by clicking on sitemap button
    Then Clicks on sports button to navigate sports product page
    Then Search for the products
    Given Navigates to special offer page by clicking on special offer button
    Then It displays the special offer products
