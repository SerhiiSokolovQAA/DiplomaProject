@StarRateTests

  Feature: Capability to rate new hotel

    @StarRateTestScenario1
    Scenario: Verify that Global Rating field is displayed in Data section of Register new Hotel page
      Given Open Chrome browser
      And Open main page
      Then Verify that Global Rating field is displayed
      Then Close browser

    @StarRateTestScenario2
    Scenario: Verify that Global Rating allows to rate new hotel
      Given Open Chrome browser
      And Open main page
      Then Verify that Global Rating field allows to rate new hotel
      Then Close browser

    @StarRateTestScenario3
    Scenario: Save new hotel with selected Global Rating
      Given Open Chrome browser
      And Open main page
      Then Fill in Name field
      Then Fill in Date
      Then Select Country and City
      Then Fill in Short Description field
      Then Fill in Description field
      Then Set Global Rating and save new hotel
      Then Close browser