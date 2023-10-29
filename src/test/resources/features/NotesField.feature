@NotesField

Feature: Notes Field testing

  @NotesFieldScenario1
  Scenario: Verify that Notes field is displayed in Data section of Register new Hotel page
    Given Open Chrome browser
    And Open main page
    Then Verify that Notes field is displayed
    Then Close browser

  @NotesFieldScenario2
  Scenario: Verify that Notes field is editable
    Given Open Chrome browser
    And Open main page
    Then Verify that Notes field is editable
    Then Close browser

  @NotesFieldScenario3
  Scenario: Verify that Notes field accepts alphanumeric values
    Given Open Chrome browser
    And Open main page
    Then Verify that Notes field accepts alphanumeric values
    Then Close browser

  @NotesFieldScenario4
  Scenario: Verify that new hotel can be saved with blank Notes field
    Given Open Chrome browser
    And Open main page
    Then Fill in Name field
    Then Fill in Date
    Then Select Country and City
    Then Fill in Short Description field
    Then Fill in Description field
    Then Do not fill in Notes field and save new hotel
    Then Close browser

  @NotesFieldScenario5
  Scenario: Verify that new hotel can be saved with not blank Notes field
    Given Open Chrome browser
    And Open main page
    Then Fill in Name field
    Then Fill in Date
    Then Select Country and City
    Then Fill in Short Description field
    Then Fill in Description field
    Then Fill in Notes field and save new hotel
    Then Close browser