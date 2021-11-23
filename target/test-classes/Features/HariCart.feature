
  @Cart    
  Feature: check the functionality of Cart page
  
  Background: Login
    Given Login with user credentials
    Then Click on Cart Icon
  
  @Add-items
  Scenario: Add Items from Home page
    Given Click on Home page
    And Click on a product
    And check the Availability 
    And Increase the quantity
    When Click on add to cart
    Then Items added
    
  @Checkout-To-Confirm-Order
  Scenario: CheckOut items from Cart
    Given Items are in the Cart
    And Enter Coupon Code
    And Enter Country Pincode State
    And Enter GiftCertificate
    When Click on CheckOut
    And Enter Billing & Delivery Address
    And Select Delivery Method
    And Select Payment Method
    And Accept Terms & Conditions
    Then Display the details
    And Click on confirm
    
  
  