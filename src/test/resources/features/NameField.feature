@NameField

Feature: Name Field testing

  @NameFieldScenario1
  Scenario: Verify that Name field is displayed in Data section of Register new Hotel page
    Given Open Chrome browser
    And Open main page
    Then Verify that Name field is displayed
    Then Close browser

  @NameFieldScenario2
  Scenario: Verify that Name field is a required field
    Given Open Chrome browser
    And Open main page
    Then Verify that Name field is a required field
    Then Close browser

  @NameFieldScenario3
  Scenario: Verify that Name field is editable
    Given Open Chrome browser
    And Open main page
    Then Verify that Name field is editable
    Then Close browser

  @NameFieldScenario4
  Scenario: Verify that Name field accepts alphanumeric values
    Given Open Chrome browser
    And Open main page
    Then Verify that Name field accepts alphanumeric values
    Then Close browser

  @NameFieldScenario5
  Scenario: Verify that Name field can not be saved blank
    Given Open Chrome browser
    And Open main page
    Then Try to save new hotel with blank Name field
    Then Close browser

  @NameFieldScenario6
  Scenario: Verify that Name field is saved correctly
    Given Open Chrome browser
    And Open main page
    Then Fill in Date
    Then Select Country and City
    Then Fill in Short Description field
    Then Fill in Description field
    Then Fill in Name field and save new hotel
    Then Close browser