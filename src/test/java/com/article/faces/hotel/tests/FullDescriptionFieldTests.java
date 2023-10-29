package com.article.faces.hotel.tests;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class FullDescriptionFieldTests extends SetUpClass {

    @Test
    public void VerifyThatShortDescriptionFieldIsDisplayed(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isFullDescriptionDisplayed(), "Verify that Full Description field is displayed in Data section  of Register new Hotel");
    }

    @Test
    public void VerifyThatFullDescriptionFieldHasAsterisk(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fullDescriptionHasAsterisk();
    }

    @Test
    public void VerifyThatFullDescriptionFieldEditable(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fullDescriptionFieldEnabled();
    }

    @Test
    public void VerifyThatFullDescriptionFieldAllowsAlphanumeric(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInFullDescrWithAssertion();
    }

    @Test
    public void VerifyThatFullDescriptionFieldCanNotBeSavedBlank() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInDate();
        mainPage.verifyThatFullDescrFieldCAnNotBeSavedBlank();
    }

    @Test
    public void SaveHotelWithValidFullDescriptionField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.randomlyRateHotel();
        mainPage.verifyThatNewHotelIsSavedWithFullDescription();
    }
}
