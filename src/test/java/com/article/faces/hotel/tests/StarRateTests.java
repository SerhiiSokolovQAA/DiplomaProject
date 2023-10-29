package com.article.faces.hotel.tests;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class StarRateTests extends SetUpClass {
    @Test
    public void VerifyThatNameFieldIsDisplayed(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isGlobalRatingFieldDisplayed(), "Verify that Global Rating field is displayed in Data section of Register new Hotel page");
    }

    @Test
    public void GlobalRatingFieldAllowsToRateTheHotel(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.randomlyRateHotel();
    }

    @Test
    public void SaveHotelWithSelectedGlobalRating() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.fillInDate();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.randomlyRateHotel();
        int selectedRating = mainPage.getSelectedRating();
        mainPage.verifyThatNewHotelIsSavedWithRating(selectedRating);
    }

}