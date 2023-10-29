package com.article.faces.hotel.tests;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class DateOfConstructionFieldTests extends SetUpClass{

    @Test
    public void VerifyThatDateOfConstructionFieldIsDisplayed(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isDateOfConstructionFieldDisplayed(), "Verify that Date of Construction field is displayed in Data section of Register new Hotel page");
    }

    @Test
    public void VerifyThatDateOfConstructionFieldHasAsterisk(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.dateFieldHasAsterisk();
    }

    @Test
    public void VerifyDateOfConstructionFieldEditable(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.dateFieldEnabled();
    }

    @Test
    public void VerifyDateOfConstructionFieldCanNotBeFilledInWithNotValidData(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInDateWithNotValidData();
    }
    @Test
    public void VerifyDateOfConstructionFieldCanBeFilledInWithValidData(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInDateWithValidData();
    }
    @Test
    public void SaveHotelWithIncorrectDateFormat() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.SaveHotelWithIncorrectDateFormat();
    }
    @Test
    public void SaveHotelWithBlankDate() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.SaveHotelWithBlankDateField();
    }

    @Test
    public void SaveHotelWithValidDateField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.verifyThatNewHotelIsSavedWithDateFieldVerification();
    }
}
