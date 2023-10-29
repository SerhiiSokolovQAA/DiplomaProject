package com.article.faces.hotel.page;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.time.Duration;


public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private int selectedRating;
    public String enteredDate;
    private String selectedCountry;
    public String selectedCity;
    private String enteredShorDescription;
    private String enteredFullDescription;
    public String formattedDate;
    public String randomDateStr;
    public String randomEnteredDate;
    public String randomAlphaNumericText;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Article']")
    public WebElement articleMenuLocator;

    @FindBy(xpath = "//span[text()='New']")
    public WebElement newMenuLocator;

    @FindBy(xpath = "//span[text()='Hotel']")
    public WebElement hotelMenuButtonLocator;

    @FindBy(xpath = "//*[@id='add_hotel']")
    public WebElement addhotel;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt62\"]")
    public WebElement savebutton;

    @FindBy(xpath = "//div[@id='title']//h2")
    public WebElement title;

    @FindBy(xpath = "//*[@id='add_hotel:name']")
    public WebElement nameField;

    @FindBy(xpath = "//*[@id='add_hotel:j_idt42']")
    public WebElement nameTitle;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt46\"]")
    public WebElement dateTitle;

    @FindBy(xpath = "//*[@for=\"add_hotel:country_input\"]")
    public WebElement countryTitle;

    @FindBy(xpath = "//*[@for=\"add_hotel:city_input\"]")
    public WebElement cityTitle;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt56\"]")
    public WebElement shortDescriptionTitle;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt58\"]")
    public WebElement fullDescriptionTitle;

    @FindBy(xpath = "//*[@id='add_hotel:dateOfConstruction_input']")
    public WebElement dateField;

    @FindBy(xpath = "//*[@id='add_hotel:country_label']")
    public WebElement countryField;

    @FindBy(xpath = "//*[@data-label='Ukraine'] | //*[@data-label='USA'] | //*[@data-label='UK']")
    List<WebElement> countryLabel;

    @FindBy(xpath = "//*[@data-label='Kyiv'] | //*[@data-label='Lviv']| //*[@data-label='Kharkiv'] | //*[@data-label='Dnipropetrovsk'] | //*[@data-label='Odesa'] | //*[@data-label='Donetsk'] | //*[@data-label='Zaporizhia'] | //*[@data-label='Mykolaiv']")
    List<WebElement>  cityOfUkraine;


    @FindBy(xpath = "//*[@data-label='New York'] | //*[@data-label='Los Angeles'] | //*[@data-label='Chicago'] | //*[@data-label='Philadelphia'] | //*[@data-label='Phoenix'] | //*[@data-label='Dallas'] | //*[@data-label='San Jose'] | //*[@data-label='Indianapolis'] | //*[@data-label='San Francisco'] | //*[@data-label='Detroit']")
    List<WebElement> cityOfUSA;

    @FindBy(xpath = "//*[@data-label='Birmingham'] | //*[@data-label='Cambridge'] | //*[@data-label='Chester'] | //*[@data-label='Derby'] | //*[@data-label='Hereford'] | //*[@data-label='Leeds'] | //*[@data-label='Liverpool'] | //*[@data-label='Manchester'] | //*[@data-label='London'] | //*[@data-label='Newcastle']")
    List<WebElement> cityOfUK;

    @FindBy(xpath = "//*[@id=\"add_hotel:city\"]/div[3]/span")
    public WebElement cityField;

    @FindBy(xpath = "//*[@id='add_hotel:short_description']")
    public WebElement shortDescription;

    @FindBy(xpath = "//*[@id='add_hotel:description']")
    public WebElement fullDescription;

    @FindBy(xpath = "//*[@id=\"add_hotel:notes\"]")
    public WebElement notesField;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt62\"]/span[2]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt43\"]/span[2]")
    public WebElement nameErrorMessage;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt51\"]/span[2]")
    public WebElement countryErrorMessage;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt55\"]/span[2]")
    public WebElement cityErrorMessage;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt57\"]/span[2]")
    public WebElement shorDescrErrorMessage;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt59\"]/span[2]")
    public WebElement fullDescrErrorMessage;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt47\"]/span[2]")
    public WebElement dateErrorMessage;

    @FindBy(xpath = "//*[@id=\"title\"]/div/h2")
    public WebElement listTitle;

    @FindBy(xpath = "//*[@id=\"add_hotel:rate\"]/div[2]/a | //*[@id=\"add_hotel:rate\"]/div[3]/a | //*[@id=\"add_hotel:rate\"]/div[4]/a | //*[@id=\"add_hotel:rate\"]/div[5]/a | //*[@id=\"add_hotel:rate\"]/div[6]/a")
    List<WebElement> selectStar;

    @FindBy(xpath = "//*[@id=\"add_hotel:rate\"]/div[1]/a")
    public WebElement clearStars;

    @FindBy(xpath = "//*[@id=\"add_hotel:j_idt44\"]")
    public WebElement globalRating;


    @FindAll({@FindBy(xpath = "//*[@data-ri]//td[3]")})
    public List<WebElement> starRateElements;

    @FindAll({@FindBy(xpath = "//*[@id=\"j_idt40:hotels_data\"]//td[4]")})
    public List<WebElement> dateElements;

    @FindAll({@FindBy(xpath = "//*[@id=\"j_idt40:hotels_data\"]//td[6]")})
    public List<WebElement> countryElements;

    @FindAll({@FindBy(xpath = "//*[@id=\"j_idt40:hotels_data\"]//td[5]")})
    public List<WebElement> cityElements;

    @FindAll({@FindBy(xpath = "//*[@id=\"j_idt40:hotels_data\"]//td[2]")})
    public List<WebElement> shortDescriptionElements;

    @FindAll({@FindBy(xpath = "//*[@id=\"j_idt40:hotels_data\"]//td[1]")})
    public List<WebElement> fullDescriptionElements;

    @FindAll({@FindBy(xpath = "//*[@id=\"j_idt40:hotels_data\"]//td[1]")})
    public List<WebElement> nameFieldTitle;

    @FindBy(xpath = "//*[@id=\"j_idt40:hotels_paginator_top\"]/span[6]/span")
    public WebElement lastPageButton;

    @FindBy(xpath = "//*[@id=\"add_hotel:city_label\"]")
    public WebElement cityLabel;

    public WebElement getLastStarRateElement() {
        if (starRateElements.size() > 0) {
            int lastIndex = starRateElements.size() - 1;
            return starRateElements.get(lastIndex);
        } else {
            return null;
        }
    }
    public WebElement getLastDateElement() {
        if (dateElements.size() > 0) {
            int lastIndex = dateElements.size() - 1;
            return dateElements.get(lastIndex);
        } else {
            return null;
        }
    }

    public WebElement getLastCountryElement() {
        if (countryElements.size() > 0) {
            int lastIndex = countryElements.size() - 1;
            return countryElements.get(lastIndex);
        } else {
            return (WebElement) this;
        }
    }
    public WebElement getLastNameElement() {
        if (nameFieldTitle.size() > 0) {
            int lastIndex = nameFieldTitle.size() - 1;
            return nameFieldTitle.get(lastIndex);
        } else {
            return (WebElement) this;
        }
    }

    public WebElement getLastCityElement() {
        if (cityElements.size() > 0) {
            int lastIndex = cityElements.size() - 1;
            return cityElements.get(lastIndex);
        } else {
            return (WebElement) this;
        }
    }

    public String getSelectedCityElement() {
        return cityLabel.getDomAttribute("label");
    }

    public WebElement getLastShortDescriptionElement() {
        if (shortDescriptionElements.size() > 0) {
            int lastIndex = shortDescriptionElements.size() - 1;
            return shortDescriptionElements.get(lastIndex);
        } else {
            return (WebElement) this;
        }
    }

    public WebElement getLastFullDescriptionElement() {
        if (fullDescriptionElements.size() > 0) {
            int lastIndex = fullDescriptionElements.size() - 1;
            return fullDescriptionElements.get(lastIndex);
        } else {
            return (WebElement) this;
        }
    }


    public RegisterHotelPage openNewHotelPage() {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(articleMenuLocator)
                .moveToElement(newMenuLocator)
                .click(hotelMenuButtonLocator)
                .build()
                .perform();
        return new RegisterHotelPage(this.driver);
    }

    public boolean isRegisterNewHotelPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title"))); // Замените на актуальный селектор элемента
        return title.isDisplayed();
    }

    public boolean isDataSectionVisible() {
        return addhotel.isDisplayed();
    }

    public boolean isSaveButtonDisplayed() {
        return savebutton.isDisplayed();
    }

    public boolean isNameFieldDisplayed() {
        return nameField.isDisplayed();
    }
    public boolean isGlobalRatingFieldDisplayed() {
        return globalRating.isDisplayed();
    }

    public boolean isDateOfConstructionFieldDisplayed() {
        return dateField.isDisplayed();
    }

    public boolean isCountryFieldDisplayed() {
        return countryField.isDisplayed();
    }

    public boolean isCityFieldDisplayed() {return cityField.isDisplayed();}

    public boolean isShortDescriptionDisplayed() {return shortDescription.isDisplayed();}

    public boolean isFullDescriptionDisplayed() {return fullDescription.isDisplayed();}

    public boolean isNotesDisplayed() {return notesField.isDisplayed();}


    public int getSelectedRating() {
        return selectedRating;
    }

    public String getEnteredDate() {
        return enteredDate;
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }
    public String getRandomDateStr() {
        return randomDateStr;
    }

    public void nameFieldHasAsterisk() {
        String labelText = nameTitle.getText();
        Assert.assertTrue(labelText.contains("*"), "There are no Asterisk beside the Name field");
    }

    public void dateFieldHasAsterisk() {
        String labelText = dateTitle.getText();
        Assert.assertTrue(labelText.contains("*"), "There are no Asterisk beside the Date field");
    }
    public void countryFieldHasAsterisk() {
        String labelText = countryTitle.getText();
        Assert.assertTrue(labelText.contains("*"), "There are no Asterisk beside the Country field");
    }

    public void cityHasAsterisk() {
        String labelText = cityTitle.getText();
        Assert.assertTrue(labelText.contains("*"), "There are no Asterisk beside the City field");
    }

    public void shortDescriptionHasAsterisk() {
        String labelText = shortDescriptionTitle.getText();
        Assert.assertTrue(labelText.contains("*"), "There are no Asterisk beside the Short Description field");
    }

    public void fullDescriptionHasAsterisk() {
        String labelText = fullDescriptionTitle.getText();
        Assert.assertTrue(labelText.contains("*"), "There are no Asterisk beside the Full Description field");
    }

    public void nameFieldEnabled() {

        Assert.assertTrue(nameField.isEnabled(), "Name field is disabled");
    }

    public void dateFieldEnabled() {

        Assert.assertTrue(dateField.isEnabled(), "Date field is disabled");
    }

    public void countryFieldEnabled() {
        Assert.assertTrue(countryField.isEnabled(), "Country field is disabled");
    }

    public void cityFieldEnabled() {
        Assert.assertTrue(cityField.isEnabled(), "City field is disabled");
    }

    public void shortDescriptionFieldEnabled() {
        Assert.assertTrue(shortDescription.isEnabled(), "Short Description field is disabled");
    }

    public void fullDescriptionFieldEnabled() {
        Assert.assertTrue(fullDescription.isEnabled(), "Full Description field is disabled");
    }

    public void notesFieldEnabled() {
        Assert.assertTrue(notesField.isEnabled(), "Full Description field is disabled");
    }

    public void verifyThatNameFieldAcceptAlphaNumericValues() {
        String randomAlphaNumericText = RandomStringUtils.randomAlphanumeric(8);
        nameField.sendKeys(randomAlphaNumericText);
        String enteredText = nameField.getAttribute("value");
        Assert.assertEquals(enteredText, randomAlphaNumericText);
    }

    public String selectRandomCountryAndCityAccordingToSelectedCountry() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        countryField.click();
        int randomIndex = new Random().nextInt(countryLabel.size());
        WebElement randomCountryLabel = countryLabel.get(randomIndex);
        wait.until(ExpectedConditions.elementToBeClickable(randomCountryLabel));
        randomCountryLabel.click();
        selectedCountry = randomCountryLabel.getAttribute("data-label");
        wait.until(ExpectedConditions.elementToBeClickable(cityField));
        cityField.click();
        if (selectedCountry.equals("Ukraine")) {
            if (cityOfUkraine.size() > 0) {
                int randomCityIndex = new Random().nextInt(cityOfUkraine.size());
                WebElement randomUkraineCityLabel = cityOfUkraine.get(randomCityIndex);
                randomUkraineCityLabel.click();
                selectedCity = randomUkraineCityLabel.getAttribute("data-label");
            }
        } else if (selectedCountry.equals("USA")) {
            if (cityOfUSA.size() > 0) {
                int randomCityIndex = new Random().nextInt(cityOfUSA.size());
                WebElement randomUSACityLabel = cityOfUSA.get(randomCityIndex);
                randomUSACityLabel.click();
                selectedCity = randomUSACityLabel.getAttribute("data-label");
            }
        } else {
            if (cityOfUK.size() > 0) {
                int randomCityIndex = new Random().nextInt(cityOfUK.size());
                WebElement randomUKCityLabel = cityOfUK.get(randomCityIndex);
                randomUKCityLabel.click();
               selectedCity = randomUKCityLabel.getAttribute("data-label");

            }
        }
        return selectedCountry;
    }

    public void selectRandomCountryAndBlankCity() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        countryField.click();
        int randomIndex = new Random().nextInt(countryLabel.size());
        WebElement randomCountryLabel = countryLabel.get(randomIndex);
        wait.until(ExpectedConditions.elementToBeClickable(randomCountryLabel));
        randomCountryLabel.click();
    }
    public String fillInDate() throws ParseException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        Random random = new Random();
        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();
        long randomDay = startDay + random.nextInt((int) (endDay - startDay));
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        randomDateStr = randomDate.format(formatter);
        dateField.sendKeys(randomDateStr);
        DateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat displayedDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedInputDate = inputDateFormat.parse(randomDateStr);
        randomDateStr = displayedDateFormat.format(parsedInputDate);
        return randomDateStr;
    }
    public void fillInDateWithNotValidData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        dateField.sendKeys("abc");
        String enteredText = dateField.getAttribute("value");
        Assert.assertEquals("", enteredText);

    }
    public void fillInDateWithValidData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        dateField.sendKeys("01/01/2023");
        String enteredText = dateField.getAttribute("value");
        Assert.assertEquals("01/01/2023", enteredText);

    }



    public void SaveHotelWithIncorrectDateFormat(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dateField));
        dateField.sendKeys("01.01.2023");
        saveButton.click();
        String ErrorMessage = dateErrorMessage.getText();
        Assert.assertEquals(ErrorMessage, "Date of Construction: " + "'01012023'" + " could not be understood as a date. Example: 10/27/23");
        dateField.clear();
        dateField.sendKeys("23.10.23");
        saveButton.click();
        String ErrorMessageTwo = dateErrorMessage.getText();
        Assert.assertEquals(ErrorMessageTwo, "Date of Construction: " + "'231023'" + " could not be understood as a date. Example: 10/27/23");
    }
    public void SaveHotelWithBlankDateField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dateField));
        saveButton.click();
        String ErrorMessage = dateErrorMessage.getText();
        Assert.assertEquals(ErrorMessage, "Date of Construction: Validation Error: Value is required.");
    }



    public void fillInShortDescr(){
        String randomAlphaNumericText = RandomStringUtils.randomAlphanumeric(8);
        shortDescription.sendKeys(randomAlphaNumericText);
        enteredShorDescription = shortDescription.getAttribute("value");
    }

    public void fillInShortDescrWithAssertion(){
        String randomAlphaNumericText = RandomStringUtils.randomAlphanumeric(8);
        shortDescription.sendKeys(randomAlphaNumericText);
        String enteredText = shortDescription.getAttribute("value");
        Assert.assertEquals(enteredText, randomAlphaNumericText);
    }

    public void fillInNotesWithAssertion(){
        String randomAlphaNumericText = RandomStringUtils.randomAlphanumeric(50);
        notesField.sendKeys(randomAlphaNumericText);
        String enteredText = notesField.getAttribute("value");
        Assert.assertEquals(enteredText, randomAlphaNumericText);
    }

    public void fillInNotesField(){
        String randomAlphaNumericText = RandomStringUtils.randomAlphanumeric(50);
        notesField.sendKeys(randomAlphaNumericText);
    }

    public void fillInFullDescrWithAssertion(){
        String randomAlphaNumericText = RandomStringUtils.randomAlphanumeric(25);
        fullDescription.sendKeys(randomAlphaNumericText);
        String enteredText = fullDescription.getAttribute("value");
        Assert.assertEquals(enteredText, randomAlphaNumericText);
    }

    public String fillInNameField(){
        randomAlphaNumericText = RandomStringUtils.randomAlphanumeric(8);
        nameField.sendKeys(randomAlphaNumericText);
        return randomAlphaNumericText;
    }

    public void fillInFullDescr(){
        String randomAlphaNumericTextForDescription = RandomStringUtils.randomAlphanumeric(25);
        fullDescription.sendKeys(randomAlphaNumericTextForDescription);
        enteredFullDescription = fullDescription.getAttribute("value");
    }

    public void verifyThatNameFieldCAnNotBeSavedBlank(){
        saveButton.click();
        String ErrorMessage = nameErrorMessage.getText();
        Assert.assertEquals(ErrorMessage, "Name: Validation Error: Value is required.");
    }
    public void verifyThatCountryFieldCAnNotBeSavedBlank(){
        saveButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(countryErrorMessage));
        String ErrorMessage = countryErrorMessage.getText();
        Assert.assertEquals(ErrorMessage, "Country: Validation Error: Value is required.");
    }

    public void verifyThatCityFieldCAnNotBeSavedBlank(){
        saveButton.click();
        String ErrorMessage = cityErrorMessage.getText();
        Assert.assertEquals(ErrorMessage, "City: Validation Error: Value is required.");
    }

    public void verifyThatShorDescrFieldCAnNotBeSavedBlank(){
        saveButton.click();
        String ErrorMessage = shorDescrErrorMessage.getText();
        Assert.assertEquals(ErrorMessage, "Short Description: Validation Error: Value is required.");
    }

    public void verifyThatFullDescrFieldCAnNotBeSavedBlank(){
        saveButton.click();
        String ErrorMessage = fullDescrErrorMessage.getText();
        Assert.assertEquals(ErrorMessage, "Description: Validation Error: Value is required.");
    }

    public void verifyThatHotelCAnNotBeSavedWithIncorrectDateFormat(){
        saveButton.click();
        String ErrorMessage = dateErrorMessage.getText();
        Assert.assertEquals(ErrorMessage, "Date of Construction: '27/10/23' could not be understood as a date. Example: 10/27/23");
    }

    public void verifyThatNewHotelIsSavedWithDateFieldVerification() throws ParseException {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
        if (ExpectedConditions.elementToBeClickable(lastPageButton) != null) {
            lastPageButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(listTitle));
        String ratingText = getLastDateElement().getText();
        System.out.println("Randomly selected date is " + randomDateStr);
        System.out.println("Saved date is " + ratingText);
        Assert.assertEquals(ratingText, randomDateStr);
    }

    public void verifyThatNewHotelIsSavedWithCountryVerification() throws ParseException {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
        if (ExpectedConditions.elementToBeClickable(lastPageButton) != null) {
            lastPageButton.click();
        }
        String countryText = getLastCountryElement().getText();
        Assert.assertEquals(countryText, selectedCountry);
    }

    public void verifyThatNewHotelIsSavedWithCityVerification() throws ParseException {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
        if (ExpectedConditions.elementToBeClickable(lastPageButton) != null) {
            lastPageButton.click();
        }
        String cityText = getLastCityElement().getText();
        Assert.assertEquals(cityText, selectedCity);
    }

    public void verifyThatNewHotelIsSavedWithShortDescriptionVerification() throws ParseException {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
        if (ExpectedConditions.elementToBeClickable(lastPageButton) != null) {
            lastPageButton.click();
        }
        String shortDescriptionText = getLastShortDescriptionElement().getText();
        Assert.assertEquals(shortDescriptionText, enteredShorDescription);
    }

    public void verifyThatNewHotelIsSaved()  {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
        if (ExpectedConditions.elementToBeClickable(lastPageButton) != null) {
            lastPageButton.click();
        }
        String randomlyEnteredName = getLastNameElement().getText();
        Assert.assertEquals(randomlyEnteredName, randomAlphaNumericText);
    }

    public void verifyThatNewHotelIsSavedWithFullDescription()  {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
    }


    public void verifyThatNewHotelIsSavedWithEnteredName()  {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
        if (ExpectedConditions.elementToBeClickable(lastPageButton) != null) {
            lastPageButton.click();
        }
        String randomlyEnteredName = getLastNameElement().getText();
        Assert.assertEquals(randomlyEnteredName, randomAlphaNumericText);
    }

    public void verifyThatNewHotelIsSavedWithNotBlankNotesField()  {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
    }

    public void verifyThatNewHotelIsSavedWithBlankNotesField()  {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
    }

    public void randomlyRateHotel() {
        int randomIndex = new Random().nextInt(selectStar.size());
        WebElement randomStar = selectStar.get(randomIndex);
        randomStar.click();

        selectedRating = randomIndex + 1;
    }

    public void verifyThatNewHotelIsSavedWithRating(int getSelectedRating) {
        saveButton.click();
        String ListMessage = listTitle.getText();
        Assert.assertEquals(ListMessage, "List of all hotels");
        if (ExpectedConditions.elementToBeClickable(lastPageButton) != null) {
            lastPageButton.click();
        }
        int savedRating = Integer.parseInt(getLastStarRateElement().getText());
        Assert.assertEquals(selectedRating, savedRating);
    }
}

