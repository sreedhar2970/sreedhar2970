Feature: Tesing Catalog Functionalities

  Background: login and click on catalog
    Given admin page login
    Then click on catalog

  @catalog_categories
  Scenario: Testing Categories under catalog
    Given under catalog select categories
    Then under categories select multiple checkboxes
    And in categories click on add new button
    Then click on save to check mandatory fields
    And enter all the mandatory fields
    And click on save button in categories
    And Finding created category in table
    When user clicks on edit button in category list
    Then check delete option both single and multiple in categories list

  @catalog_products
  Scenario: Testing Products under catalog
    Given under catalog select Products
    When under Products select multiple checkboxes
    When in products click on add new button
    Then click on save to check mandatory fields in products
    And fill mandatory details in add new products page
    And click save in product add page
    And using filter button finding products
    When Finding created Product in table
    When user clicks on edit button in product list
    When finding edited product using filter
    Then check delete option both single and multiple in products list

  @catalog_Recurring_profiles
  Scenario: Testing Recurring profiles under catalog
    Given under catalog select Recurring profiles
    When click on add new button in recurring profiles
    Then click on save to check mandatory fields in Recurring
    And fill details recurring profiles
    And check recurring profile list
    And click on edit button
    Then check delete option both single and multiple in Recurring profile list

  @catalog_Filters
  Scenario: Testing Filters under catalog
    Given under catalog select Filters
    When click on add new button in filters
    Then click on save to check mandatory fields in Filters
    And fill details in filter and save
    And check Filter list
    And click on edit button in filter list
    Then check delete option both single and multiple in Filter list

  @catalog_Attributes
  Scenario: Testing Attributes under catalog
    Given under catalog select Attributes
    When in attributes dropdown select attributes
    Then click on add new in attributes
    Then click on save to check mandatory fields in attributes
    Then fill the fields in attributes
    Then fill the required field
    Then print Attribute list
    Then check edit button Attributes
    Then check delete option in attributes

  @catalog_Attribute_Group
  Scenario: Testing Attribute Group under catalog
    Given under catalog select Attributes
    When click on attribute group
    Then click on add new button in attribute group
    Then click on save to check mandatory fields in attribute group
    Then Fill details under attribute group and save
    Then printing attribute group list
    Then check edit button Attributes Group
    Then check delete option in attributes group

  @catalog_Options
  Scenario: Testing Options under catalog
    Given under catalog select Options
    When click on add new button in Options
    Then click on save to check mandatory fields in options
    And fill details in Options and save
    And check Options list
    And click on edit button in Options list
    Then check delete option in Options

  @catalog_Manufacturers
  Scenario: Testing Manufacturers under catalog
    Given under catalog select Manufacturers
    When click on add new button in Manufacturers
    Then click on save to check mandatory fields in Manufacturers
    Then fill details under Manufacturers
    And click on save in Manufacturers
    Then printing Manufacturer list
    Then checking edit button in manufacturers
    Then check delete option in Manufacturers

  @catalog_Downloads
  Scenario: Testing Downloads under catalog
    Given under catalog select Downloads
    When click on add new button in Downloads
    Then click on save to check mandatory fields in Downloads
    Then fill details under Downloads
    And click on save in Downloads
    Then printing Downloads list
    Then checking edit button in Downloads
    Then check delete option in Downloads

  @catalog_Reviews
  Scenario: Testing Reviews under catalog
    Given under catalog select Reviews
    When click on add new button in Reviews
    Then click on save to check mandatory fields in Reviews
    Then fill details under Reviews
    And click on save in Reviews
    And check filter button in reviews and print them
    Then Click on Edit button in reviews
    Then check delete option in Reviews

  @catalog_Information
  Scenario: Testing Reviews under Information
    Given under catalog select Information
    When click on add new button in Information
    Then click on save to check mandatory fields in Information
    Then fill details under Information
    And click on save in Information
    And print Information List
    Then click on edit in Information
    Then check checkbox delete in information
