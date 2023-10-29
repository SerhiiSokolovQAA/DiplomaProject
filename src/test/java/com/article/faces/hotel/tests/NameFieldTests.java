package com.article.faces.hotel.tests;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class NameFieldTests extends SetUpClass {
    @Test
    public void VerifyThatNameFieldIsDisplayed(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isNameFieldDisplayed(), "Verify that Name field is displayed in Data section of Register new Hotel page");
    }
    @Test
    public void VerifyNameFieldAsterisk(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.nameFieldHasAsterisk();
    }
    @Test
    public void VerifyNameFieldEditable(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.nameFieldEnabled();
    }
    @Test
    public void VerifyThatNameFieldAcceptAlphaNumericValues(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.verifyThatNameFieldAcceptAlphaNumericValues();
    }

    @Test
    public void VerifyThatNewHotelCanNotBeSavedWithBlankNameField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInDate();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.verifyThatNameFieldCAnNotBeSavedBlank();
    }

    @Test
    public void VerifyThatNewHotelCanBeSaved() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.fillInDate();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.verifyThatNewHotelIsSavedWithEnteredName();
    }
}

