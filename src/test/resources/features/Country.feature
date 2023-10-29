@CountryField

Feature: Country Field testing

  @CountryFieldScenario1
  Scenario: Verify that Country field is displayed in Data section of Register new Hotel page
    Given Open Chrome browser
    And Open main page
    Then Verify that Country field is displayed
    Then Close browser

  @CountryFieldScenario2
  Scenario: Verify that Country field is a required field
    Given Open Chrome browser
    And Open main page
    Then Verify that Country field is required field
    Then Close browser

  @CountryFieldScenario3
  Scenario: User can not save new hotel with blank Country field
    Given Open Chrome browser
    And Open main page
    And Fill in Name field
    And Fill in Date
    And Fill in Short Description field
    And Fill in Description field
    And Click the [Save] button and verify that new hotel is not created with blank Country
    And Close browser

  @CountryFieldScenario4
  Scenario: Verify that new hotel is saved with correct Country
    Given Open Chrome browser
    And Open main page
    Then Verify that City field enabled
    Then Fill in Name field
    Then Fill in Date
    Then Select Country and City
    Then Fill in Short Description field
    Then Fill in Description field
    Then Click the [Save] button and verify that new hotel is created with correct Country
    And Close browser

