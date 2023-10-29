@ShortDescriptionField

Feature: Short Description Field testing

  @ShortDescriptionFieldScenario1
  Scenario: Verify that Short Description field is displayed in Data section of Register new Hotel page
    Given Open Chrome browser
    And Open main page
    Then Verify that Short Description field is displayed
    Then Close browser

  @ShortDescriptionFieldScenario2
  Scenario: Verify that Short Description field is required field
    Given Open Chrome browser
    And Open main page
    Then Verify that Short Description field is required field
    Then Close browser

  @ShortDescriptionFieldScenario3
  Scenario: Verify that Short Description field is editable
    Given Open Chrome browser
    And Open main page
    Then Verify that Short Description field is editable
    Then Close browser

  @ShortDescriptionFieldScenario4
  Scenario: Verify that Short Description field accepts alphanumeric values
    Given Open Chrome browser
    And Open main page
    Then Verify that Short Description field accepts alphanumeric values
    Then Close browser

  @ShortDescriptionFieldScenario5
  Scenario: Verify that new hotel can not be saved with blank Short Description field
    Given Open Chrome browser
    And Open main page
    Then Try to save new hotel wih blank Short Description field
    Then Close browser

  @ShortDescriptionFieldScenario6
  Scenario: Save new hotel with filled in Short Description field
    Given Open Chrome browser
    And Open main page
    Then Fill in Name field
    Then Fill in Date
    Then Select Country and City
    Then Fill in Description field
    Then Fill in Short Description field and save new hotel
    Then Close browser