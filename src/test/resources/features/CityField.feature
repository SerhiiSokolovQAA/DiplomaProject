@CityField

Feature: City Field testing

  @CityFieldScenario1
  Scenario: Verify that City field is displayed in Data section of Register new Hotel page
    Given Open Chrome browser
    And Open main page
    Then Verify that City field is displayed
    Then Close browser

  @CityFieldScenario2
  Scenario: Verify that City field is a required field
    Given Open Chrome browser
    And Open main page
    Then Verify that City field is required field
    Then Close browser

  @CityFieldScenario3
  Scenario: User can not save new hotel with blank City field
    Given Open Chrome browser
    And Open main page
    And Fill in Name field
    And Fill in Date
    And Select country
    And Fill in Short Description field
    And Fill in Description field
    And Click the [Save] button and verify that new hotel is not created with blank City name
    And Close browser


  @CityFieldScenario4
  Scenario: Verify that new hotel is saved with correct City
    Given Open Chrome browser
    And Open main page
    Then Verify that City field enabled
    Then Fill in Name field
    Then Fill in Date
    Then Select Country and City
    Then Fill in Short Description field
    Then Fill in Description field
    Then Click the [Save] button and verify that new hotel is created with correct City
    And Close browser

