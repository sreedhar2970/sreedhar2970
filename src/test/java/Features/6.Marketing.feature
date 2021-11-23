Feature: Title of your feature

  Background: Login and click on sidebar
    Given login admin page
    When click sidebar
    Given user selects Marketing inside sidebar

  @Marketing_Marketing
  Scenario: Testing Marketing under Marketing
    When user select Marketing under Marketing
    Then click on add new marketing
    Then fill details
    Then click on save
    Then click on filter

  @Affiliates_Marketing
  Scenario: Testing Affiliates under Marketing
    Given user selects Affiliates under Marketing
    Then click on add new1
    And fill details1
    Then click on Payment Details
    And fill details20
    Then click on save1
    Then click on edit1
    And click on cancel1
    Then single check box deletion1
    And multiple check box deletion1
    Then click on filter1

  @Coupons_Marketing
  Scenario: Testing Coupons under Marketing
    Given user selects Coupons under Marketing
    Then click on add new2
    And fill details2
    Then click on save2
    Then click on edit2
    And click on cancel2
    Then single check box deletion2
    And multiple check box deletion2

  @Mail_Marketing
  Scenario: Testing Mail under Marketing
    Given user selects Mail under Marketing
    Then fill details3
    Then click on send
    And click on cancel3
