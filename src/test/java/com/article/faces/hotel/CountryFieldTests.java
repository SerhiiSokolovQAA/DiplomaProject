package com.article.faces.hotel;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class CountryFieldTests extends SetUpClass{
    @Test
    public void VerifyThatCountryFieldIsDisplayed(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isCountryFieldDisplayed(), "Verify that Country field is displayed in Data section of Register new Hotel page");
    }

    @Test
    public void VerifyThatCountryFieldHasAsterisk(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.countryFieldHasAsterisk();
    }

    @Test
    public void VerifyThatCountryFieldEditable(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.countryFieldEnabled();
    }

    @Test
    public void VerifyThatNewHotelCanNotBeSavedWithBlankCountryField() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.fillInDate();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.verifyThatCountryFieldCAnNotBeSavedBlank();
    }

    @Test
    public void SaveHotelWithValidCountryField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.verifyThatNewHotelIsSavedWithCountryVerification();
    }
}
