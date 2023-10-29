@DateOfConstructionField

Feature: Date of Construction field feature

  @DateOfConstructionFieldScenario1
  Scenario: Verify that Date of Construction field is displayed in Data section of Register new Hotel page
    Given Open Chrome browser
    And Open main page
    Then Verify that Date of Construction field is displayed
    Then Close browser

  @DateOfConstructionFieldScenario2
  Scenario: Verify that Date of Construction field is required field
    Given Open Chrome browser
    And Open main page
    Then Verify that Date of Construction field is required field
    Then Close browser

  @DateOfConstructionFieldScenario3
  Scenario:  Verify that Date Of Construction field can not be filled in with not valid date format
    Given Open Chrome browser
    And Open main page
    And Fill in Name field
    And Select Country and City
    And Fill in Short Description field
    And Fill in Description field
    And Click the [Save] button and verify that new hotel is not created with not valid date format
    And Close browser

  @DateOfConstructionFieldScenario4
  Scenario:  Verify that Date Of Construction field does not accepts alphabetical symbols
    Given Open Chrome browser
    And Open main page
    And Fill in Name field
    And Select Country and City
    And Fill in Short Description field
    And Fill in Description field
    Then Try to fill in Date Of Construction field with alphabetical symbols
    And Close browser

  @DateOfConstructionFieldScenario5
  Scenario:  Verify that Date Of Construction field can not be saved blank
    Given Open Chrome browser
    And Open main page
    And Fill in Name field
    And Select Country and City
    And Fill in Short Description field
    And Fill in Description field
    Then Try to save new hotel with blank Date Of Construction
    And Close browser

  @DateOfConstructionFieldScenario6
  Scenario:  Save new hotel with filled in Date Of Construction field
    Given Open Chrome browser
    And Open main page
    And Fill in Name field
    And Select Country and City
    And Fill in Short Description field
    And Fill in Description field
    Then Fill in Date and save new hotel
    And Close browser