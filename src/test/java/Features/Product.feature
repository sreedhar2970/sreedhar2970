Feature: productpage

  Background: Navigate & Login
    Given The user navigated to "http://retailm1.upskills.in/"
    When Enters "sreedharreddy2970@gmail.com" and "Sreedhar@12"

  @productpage
  Scenario: verify functionality of cart icon
    Given The item should be added to cart
    Then The cart should be displyed

  @Myorders
  Scenario: verify the functionality of myorders page
    Given My account and My orders page will be displayed
    And click on the list of text available and check them
    Then Navigate back
