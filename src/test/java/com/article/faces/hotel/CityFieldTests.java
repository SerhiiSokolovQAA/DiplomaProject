package com.article.faces.hotel;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class CityFieldTests extends SetUpClass {

    @Test
    public void VerifyThatCityFieldIsDisplayed(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isCityFieldDisplayed(), "Verify that City field is displayed in Data section of Register new Hotel page");
    }

    @Test
    public void VerifyThatCityFieldHasAsterisk(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.cityHasAsterisk();
    }

    @Test
    public void VerifyThatCItyFieldEditable(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.cityFieldEnabled();
    }

    @Test
    public void VerifyThatNewHotelCanNotBeSavedWithBlankCityField() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.fillInDate();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.selectRandomCountryAndBlankCity();
        mainPage.verifyThatCityFieldCAnNotBeSavedBlank();
    }

    @Test
    public void SaveHotelWithValidCityField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.verifyThatNewHotelIsSavedWithCityVerification();
    }
}
