package com.article.faces.hotel;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Properties;

public class StepsDefinition extends SetUpClass {

    public String selectedCity;
    public String selectedCountry;
    public String randomDateStr;
    public String randomEnteredDate;
    public WebDriver driver;

    @Given("^Open Chrome browser$")
    public void setUp() {
        Properties prop = new Properties();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream input = classLoader.getResourceAsStream("properties/properties.properties");
            prop.load(input);
            String chromedriverPath = prop.getProperty("chromedriver.path");
            System.setProperty("webdriver.chrome.driver", chromedriverPath);
            driver = new ChromeDriver();
            driver.navigate().to("http://localhost:8080/article/faces/welcome.xhtml");
            driver.manage().window().maximize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Given("^Open FireFox browser$")
    public void setUpFireFox() {
        Properties prop = new Properties();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream input = classLoader.getResourceAsStream("properties/properties.properties");
            prop.load(input);
            String firefoxdriverPath = prop.getProperty("firefoxdriver.path");
            System.setProperty("webdriver.firefox.driver", firefoxdriverPath);
            driver = new FirefoxDriver();
            driver.navigate().to("http://localhost:8080/article/faces/welcome.xhtml");
            driver.manage().window().maximize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @And("^Open main page$")
    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
    }

    @And("Fill in Name field")
    public void fillInNameField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInNameField();
    }

    @And("Close browser")
    public void closeBrowser() {
            if (driver != null) {
                driver.quit();
            }
        }

    @And("Fill in Date")
    public void fillInDate() throws ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInDate();
    }

    @Then("Select Country and City")
    public void selectCountryAndCity() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
    }

    @And("Select country")
    public void selectCountry() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectRandomCountryAndBlankCity();
    }

    @And("Fill in Short Description field")
    public void fillInShortDescriptionField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInShortDescr();
    }

    @And("Fill in Description field")
    public void fillInDescriptionField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInFullDescr();
    }

    @And("Click the [Save] button")
    public void clickTheSaveButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.saveButton.click();
    }

    @And("Click the [Save] button and verify that new hotel is not created with blank City name")
    public void clickTheSaveButtonAndVerifyThatNewHotelIsNotCreatedWithBlankCityName() {
        MainPage mainPage = new MainPage(driver);
        mainPage.verifyThatCityFieldCAnNotBeSavedBlank();
    }

    @Then("Verify that City field is displayed")
    public void verifyThatCityFieldIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isCityFieldDisplayed(), "Verify that City field is displayed in Data section of Register new Hotel page");
    }

    @Then("Verify that City field is required field")
    public void verifyThatCityFieldIsRequiredField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cityHasAsterisk();
    }

    @Then("Verify that City field enabled")
    public void verifyThatCityFieldEnabled() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cityFieldEnabled();
    }

    @Then("Click the [Save] button and verify that new hotel is created with correct City")
    public void clickTheSaveButtonAndVerifyThatNewHotelIsCreatedWithCorrectCity() throws ParseException, InterruptedException {
        MainPage mainPage = new MainPage(driver);
        selectedCity = mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.verifyThatNewHotelIsSavedWithCityVerification();
    }


    @Then("Verify that Country field is displayed")
    public void verifyThatCountryFieldIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isCountryFieldDisplayed(), "Verify that Country field is displayed in Data section of Register new Hotel page");
    }

    @Then("Verify that Country field is required field")
    public void verifyThatCountryFieldIsRequiredField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.countryFieldHasAsterisk();
    }

    @And("Click the [Save] button and verify that new hotel is not created with blank Country")
    public void clickTheSaveButtonAndVerifyThatNewHotelIsNotCreatedWithBlankCountry() throws ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInNameField();
        mainPage.fillInDate();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.verifyThatCountryFieldCAnNotBeSavedBlank();
    }

    @Then("Click the [Save] button and verify that new hotel is created with correct Country")
    public void clickTheSaveButtonAndVerifyThatNewHotelIsCreatedWithCorrectCountry() throws ParseException, InterruptedException {
        MainPage mainPage = new MainPage(driver);
        selectedCountry = mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.verifyThatNewHotelIsSavedWithCountryVerification();
    }

    @Then("Verify that Date of Construction field is displayed")
    public void verifyThatDateOfConstructionFieldIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isDateOfConstructionFieldDisplayed(), "Verify that Date of Construction field is displayed in Data section of Register new Hotel page");
    }

    @Then("Verify that Date of Construction field is required field")
    public void verifyThatDateOfConstructionFieldIsRequiredField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.dateFieldHasAsterisk();
    }

    @And("Click the [Save] button and verify that new hotel is not created with not valid date format")
    public void clickTheSaveButtonAndVerifyThatNewHotelIsNotCreatedWithNotValidDataInDateOfConstructionField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.SaveHotelWithIncorrectDateFormat();
    }

    @Then("Try to fill in Date Of Construction field with alphabetical symbols")
    public void fillInDateOfConstructionFieldWithNotValidData() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInDateWithNotValidData();
    }

    @Then("Try to save new hotel with blank Date Of Construction")
    public void tryToSaveNewHotelWithBlankDateOfConstruction() {
        MainPage mainPage = new MainPage(driver);
        mainPage.SaveHotelWithBlankDateField();
    }

    @Then("Fill in Date and save new hotel")
    public void saveNewHotelWithInDateOfConstructionFieldVerification() throws ParseException {
        MainPage mainPage = new MainPage(driver);
        randomEnteredDate = mainPage.fillInDate();
        mainPage.verifyThatNewHotelIsSavedWithDateFieldVerification();
    }

    @Then("Verify that Full Description field is displayed")
    public void verifyThatFullDescriptionFieldIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isFullDescriptionDisplayed(), "Verify that Full Description field is displayed in Data section  of Register new Hotel");
    }

    @Then("Verify that Full Description field is a required field")
    public void verifyThatFullDescriptionFieldIsARequiredField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fullDescriptionHasAsterisk();
    }

    @Then("Verify that Full Description field is editable")
    public void verifyThatFullDescriptionFieldIsIsEditable() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fullDescriptionFieldEnabled();
    }

    @Then("Verify that Full Description field accepts alphanumeric values")
    public void verifyThatFullDescriptionFieldAcceptsAlphanumericValues() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInFullDescrWithAssertion();
    }

    @Then("Try to save new hotel with blank Full Description field")
    public void tryToSaveNewHotelWithBlankFullDescriptionField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInDate();
        mainPage.verifyThatFullDescrFieldCAnNotBeSavedBlank();
    }

    @Then("Fill in Full Description field and save new hotel")
    public void fillInFullDescriptionFieldAndSaveNewHotel() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInFullDescr();
        mainPage.verifyThatNewHotelIsSavedWithFullDescription();
    }

    @Then("Verify that Name field is displayed")
    public void verifyThatNameFieldIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isNameFieldDisplayed(), "Verify that Name field is displayed in Data section of Register new Hotel page");
    }

    @Then("Verify that Name field is a required field")
    public void verifyThatNameFieldIsARequiredField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.nameFieldHasAsterisk();
    }

    @Then("Verify that Name field is editable")
    public void verifyThatNameFieldIsEditable() {
        MainPage mainPage = new MainPage(driver);
        mainPage.nameFieldEnabled();
    }

    @Then("Verify that Name field accepts alphanumeric values")
    public void verifyThatNameFieldAcceptsAlphanumericValues() {
        MainPage mainPage = new MainPage(driver);
        mainPage.verifyThatNameFieldAcceptAlphaNumericValues();
    }

    @Then("Try to save new hotel with blank Name field")
    public void tryToSaveNewHotelWithBlankNameField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInDate();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.verifyThatNameFieldCAnNotBeSavedBlank();
    }

    @Then("Fill in Name field and save new hotel")
    public void fillInNameFieldAndSaveNewHotel() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInNameField();
        mainPage.verifyThatNewHotelIsSavedWithEnteredName();
    }

    @Then("Verify that Notes field is displayed")
    public void verifyThatNotesFieldIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isNotesDisplayed(), "Verify that Notes field is displayed in Data section  of Register new Hotel");
    }

    @Then("Verify that Notes field is editable")
    public void verifyThatNotesFieldIsEditable() {
        MainPage mainPage = new MainPage(driver);
        mainPage.notesFieldEnabled();
    }

    @Then("Verify that Notes field accepts alphanumeric values")
    public void verifyThatNotesFieldAcceptsAlphanumericValues() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInNotesWithAssertion();
    }

    @Then("Do not fill in Notes field and save new hotel")
    public void doNotFillInNotesFieldAndSaveNewHotel() {
        MainPage mainPage = new MainPage(driver);
        mainPage.verifyThatNewHotelIsSavedWithBlankNotesField();
    }

    @Then("Fill in Notes field and save new hotel")
    public void fillInNotesFieldAndSaveNewHotel() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInNotesField();
        mainPage.verifyThatNewHotelIsSavedWithNotBlankNotesField();
    }

    @Then("Verify that New Hotel Page is displayed")
    public void verifyThatNewHotelPageIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isRegisterNewHotelPage(), "Verify that Register new Hotel page is displayed when the user selects Article->New->Hotel");
    }

    @Then("Verify that Data Section is displayed")
    public void verifyThatDataSectionIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isDataSectionVisible(), "Verify that Data section is displayed on Register New Hotel");
    }

    @Then("Verify that [Save] button is displayed")
    public void verifyThatSaveButtonIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isSaveButtonDisplayed(), "Verify that save button is displayed on Register new Hotel");
    }

    @Then("Verify that Short Description field is displayed")
    public void verifyThatShortDescriptionFieldIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isShortDescriptionDisplayed(), "Verify that Short Description field is displayed in Data section  of Register new Hotel");
    }

    @Then("Verify that Short Description field is required field")
    public void verifyThatShortDescriptionFieldIsRequiredField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.shortDescriptionHasAsterisk();
    }

    @Then("Verify that Short Description field is editable")
    public void verifyThatShortDescriptionFieldIsEditable() {
        MainPage mainPage = new MainPage(driver);
        mainPage.shortDescriptionFieldEnabled();
    }

    @Then("Verify that Short Description field accepts alphanumeric values")
    public void verifyThatShortDescriptionFieldAcceptsAlphanumericValues() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInShortDescrWithAssertion();
    }

    @Then("Try to save new hotel wih blank Short Description field")
    public void tryToSaveNewHotelWihBlankShortDescriptionField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.verifyThatShorDescrFieldCAnNotBeSavedBlank();
    }

    @Then("Fill in Short Description field and save new hotel")
    public void fillInShortDescriptionFieldAndSaveNewHotel() throws ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillInShortDescr();
        mainPage.verifyThatNewHotelIsSavedWithShortDescriptionVerification();
    }

    @Then("Verify that Global Rating field is displayed")
    public void verifyThatGlobalRatingFieldIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isGlobalRatingFieldDisplayed(), "Verify that Global Rating field is displayed in Data section of Register new Hotel page");
    }

    @Then("Verify that Global Rating field allows to rate new hotel")
    public void verifyThatGlobalRatingFieldAllowsToRateNewHotel() {
        MainPage mainPage = new MainPage(driver);
        mainPage.randomlyRateHotel();
    }

    @Then("Set Global Rating and save new hotel")
    public void setGlobalRatingAndSaveNewHotel() {
        MainPage mainPage = new MainPage(driver);
        mainPage.randomlyRateHotel();
        int selectedRating = mainPage.getSelectedRating();
        mainPage.verifyThatNewHotelIsSavedWithRating(selectedRating);
    }

}
