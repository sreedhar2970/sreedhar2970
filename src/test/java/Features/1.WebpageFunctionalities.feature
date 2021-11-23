@runallscenario
Feature: webpage Functionalities

  @urltest
  Scenario: Url Test
    Given Valid and Invalid url
    When comparing correct and incorrect url
    Then valid url is detected

  @admin_login
  Scenario: Login
    Given admin page login

  @credentials
  Scenario Outline: Verify login functionality with existing account
    Given user at login page
    When enters  <username> and <password>
    Then click admin login

    Examples: 
      | username | password   |
      | admin    | admin@123  |
      | testingg | admin@1234 |

  @forgotpassword
  Scenario: User clicks on forgot password
    Given user at login page
    When User clicks forget password
    And User enters email-id
    Then clicks on Reset

  @visibilityandfunctionality
  Scenario: Checking the visibility and functionality of notification,Home and Logout is visible in top right corner
    Given admin page login
    When finding the icons
    Then visibility
    And click on notification and home button
    When under home dropdown select retail
    Then Retail customer webpage is opened
    And switch to parent window
    Then click on logout

  @sidebar
  Scenario: Visibility and functionality of sidebar
    Given admin page login
    When user clicks on sidebar
    Then visibile
