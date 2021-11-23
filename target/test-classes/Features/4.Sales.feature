Feature: Sales Testing

  Background: 
    Given user login
    When click on sidebar

  @orders_1
  Scenario: Testing Orders under Sales
    Given user selects Sales in sidebar
    When user select Orders under Sales
    Then click on add new
    Then fill details orders

  @orders_2
  Scenario: Filtering the Orders
    Then deletion of single order
    Then deletion of multiple orders
    Then filtering the orders

  @recurring
  Scenario: Testing Recurring profiles under Sales
    Given user selects Recurring profiles under Sales
    When filter the profiles if available

  @returns
  Scenario: Testing Returns under Sales
    Given user selects Returns under Sales
    When add return details
    Then deletion of single return
    Then deletion of multiple returns
    Then filtering the returns

  @gift_vouchers
  Scenario: Testing Gift Vouchers under Sales
    Given user selects voucher themes under Sales
    When add new theme
    Then user can delete single or multiple themes
    Then fill voucher details
    Then mail the voucher details
    Then delete multiple vouchers
