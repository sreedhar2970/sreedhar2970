

@Order-history&Return
Feature: display Order History
  
  Background: User Login
    Given Login with credentials
   
  @Order-History  
  Scenario: View Order History
    Given Click on My order history
    And Click on Order Information
    Then display the Orders 
    And Click on Continue
    
  @Return-Items    
  Scenario: Items Return
    Given Click on My order history
    And Click on Order Information
    And CLick on return button
    And Enter the Details for Return
    Then Click on Submit

