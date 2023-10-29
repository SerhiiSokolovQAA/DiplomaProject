@OpenNewHotelPage

  Feature: Add New Hotel Page

    @NewHotelPageScenario1
    Scenario: Verify that Register new Hotel page is displayed
      Given Open Chrome browser
      And Open main page
      Then Verify that New Hotel Page is displayed
      Then Close browser

    @NewHotelPageScenario2
    Scenario: Verify that Data Section is displayed in Register new Hotel page
      Given Open Chrome browser
      And Open main page
      Then Verify that Data Section is displayed
      Then Close browser

    @NewHotelPageScenario3
    Scenario: Verify that [Save] button is present in Data Section
      Given Open Chrome browser
      And Open main page
      Then Verify that [Save] button is displayed
      Then Close browser