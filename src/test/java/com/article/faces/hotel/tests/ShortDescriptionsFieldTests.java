package com.article.faces.hotel.tests;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class ShortDescriptionsFieldTests extends SetUpClass {

    @Test
    public void VerifyThatShortDescriptionFieldIsDisplayed(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isShortDescriptionDisplayed(), "Verify that Short Description field is displayed in Data section  of Register new Hotel");
    }

    @Test
    public void VerifyThatShortDescriptionFieldHasAsterisk(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.shortDescriptionHasAsterisk();
    }

    @Test
    public void VerifyThatShortDescriptionFieldEditable(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.shortDescriptionFieldEnabled();
    }

    @Test
    public void VerifyThatShortDescriptionFieldAllowsAlphanumeric(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInShortDescrWithAssertion();
    }
    @Test
    public void VerifyThatShortDescriptionFieldCanNotBeSavedBlank() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.verifyThatShorDescrFieldCAnNotBeSavedBlank();
    }

    @Test
    public void SaveHotelWithValidShortDescriptionField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.verifyThatNewHotelIsSavedWithShortDescriptionVerification();
    }
}