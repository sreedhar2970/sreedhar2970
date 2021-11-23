Feature: Verifying the Product page

  Background: login
    Given The user navigated to "http://retailm1.upskills.in/"
    When Enters "rahulpadma321@gmail.com" and "Reddy@108"

  @productpage
  Scenario: Verifying product page functionalities
    Given Navigates to home page by clicking on the Home button
    Then Clicks on Finger ring product in featured product
    And User Enters the "10" and  Delivery "584358"
    Then clicks on the wish-list button and Add to cart button

  @review
  Scenario: verifying the Review writing page
    Given Navigates to home page by clicking on the Home button
    Then Clicks on Finger ring product in featured product
    Given Navigate review writing page by clicking on the write a review button
    Then Enters name and Review
    And gives the rating by clicking radio button
    Then clicks on the continue button

  @socialmedia
  Scenario: verifying the social media icons
    Given Navigates to home page by clicking on the Home button
    Then Clicks on Finger ring product in featured product
    And Clicks on facebook icon
