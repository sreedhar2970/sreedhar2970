
@Wish-list
Feature: Verify the wish-list page

  Background: User logged in & clicks on wishlist
    Given Login with user Credentials
    
  @functionality
  Scenario: Response on adding items to wish-list
    Given user adds item to the wish-list 
    When Message when items added
    Then User clicks on wishlist icon
    And Content is displayed
      
  @content-when-empty
  Scenario: Response when user clicks on Wishlist
    Given User clicks on wishlist icon
    Then Wishlist content when empty
    
   @remove-items
   Scenario: Response when item Removed
    Given User clicks on wishlist icon
    When Click on Item-remove button
    Then Item is Removed
    
   @Items-WishList-To-Cart
   Scenario: To add items from Wishlist to Cart
    Given Login with user Credentials
    And User clicks on wishlist icon
    When user clicks on Cart Icon
    Then Items Must be added to cart
   
   
