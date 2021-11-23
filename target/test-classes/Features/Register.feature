Feature: Profile button



   
  @register
  Scenario: customer Registration
    Given The user navigated to the register page
    When The user enters the required data
    And clicks on register button
    Then It displays registration successful

  @login
  Scenario: customer login
    Given The user navigated to "http://retailm1.upskills.in/"
    When Enters "sreedharreddy2970@gmail.com" and "Sreedhar@12"
    Then click login

  @invalidcredentials
  Scenario: customer Registration with invalid credentials
   Given The user navigated to "http://retailm1.upskills.in/"
    When Enters "sreedharreddy2970@gmail.com" and "Sreedha@12"
    Then click on login

  @Forgotpassword
  Scenario: customer forget the password
   Given The user navigated to "http://retailm1.upskills.in/"
   When Enters "sreedharreddy2970@gmail.com" and "Sreedha@12"
    And it displays the wrong password
    And the user clicks on the forgot password
    Then The user will receive a link to email to reset password

 