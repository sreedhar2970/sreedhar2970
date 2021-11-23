Feature: Tesing Catalog DashBoardFunctionalities

  Background: login and click on catalog
    Given admin page login
    Given user at Dashboard

  @Dashboard_total_orders
  Scenario: Testing total orders in Dashboard
    When User clicks on total orders
    Then total orders page is opened

  @Dashboard_total_sales
  Scenario: Testing total sales in Dashboard
    When User clicks on total sales
    Then total sales page is opened

  @Dashboard_total_customers
  Scenario: Testing total sales in Dashboard
    When User clicks on total customers
    Then total customers page is opened

  @Dashboard_total_Peopleonline
  Scenario: Testing total people online in Dashboard
    When User clicks on total People online
    Then total people online page is opened

  @Dashboard_Worldmap
  Scenario: Testing Worldmap in Dashboard
    When Worldmap is visible
    Then Checking zoom in and out

  @Dashboard_Sales_analytics
  Scenario: Testing Sales Analytics in Dashboard
    When Sales Analytics is visible
    Then Checking calender icon

  @Dashboard_Recent_Activity
  Scenario: Testing Recent Activity Analytics in Dashboard
    When Recent Activity is visible
    Then checking user details

  @Dashboard_Latest_Orders
  Scenario: Testing Latest orders in Dashboard
    When Latest orders is visible
    Then checking user Latest orders
