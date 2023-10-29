@FullDescriptionField

Feature: Full Description Field testing

  @FullDescriptionFieldScenario1
  Scenario: Verify that Full Description field is displayed in Data section of Register new Hotel page
    Given Open Chrome browser
    And Open main page
    Then Verify that Full Description field is displayed
    Then Close browser

  @FullDescriptionFieldScenario2
  Scenario: Verify that Full Description field is a required field
    Given Open Chrome browser
    And Open main page
    Then Verify that Full Description field is a required field
    Then Close browser

  @FullDescriptionFieldScenario3
  Scenario: Verify that Full Description field is editable
    Given Open Chrome browser
    And Open main page
    Then Verify that Full Description field is editable
    Then Close browser

  @FullDescriptionFieldScenario4
  Scenario: Verify that Full Description field is editable
    Given Open Chrome browser
    And Open main page
    Then Verify that Full Description field accepts alphanumeric values
    Then Close browser

  @FullDescriptionFieldScenario5
  Scenario: Verify that Full Description field can not be saved blank
    Given Open Chrome browser
    And Open main page
    Then Try to save new hotel with blank Full Description field
    Then Close browser

  @FullDescriptionFieldScenario6
  Scenario: Save new hotel with filled in Full Description field
    Given Open Chrome browser
    And Open main page
    Then Fill in Name field
    Then Fill in Date
    Then Select Country and City
    Then Fill in Short Description field
    Then Fill in Full Description field and save new hotel
    Then Close browser