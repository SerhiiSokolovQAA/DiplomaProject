package com.article.faces.hotel.tests;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class NotesFieldTests extends SetUpClass {

    @Test
    public void VerifyThatNotesFieldIsDisplayed(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isNotesDisplayed(), "Verify that Notes field is displayed in Data section  of Register new Hotel");
    }

    @Test
    public void VerifyThatNotesFieldEditable(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.notesFieldEnabled();
    }

    @Test
    public void VerifyThatNotesFieldAllowsAlphanumeric(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNotesWithAssertion();
    }

    @Test
    public void SaveNewHotelWithBlankNotesField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.randomlyRateHotel();
        mainPage.verifyThatNewHotelIsSavedWithBlankNotesField();
    }

    @Test
    public void SaveNewHotelWithNotBlankNotesField() throws InterruptedException, ParseException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        mainPage.fillInNameField();
        mainPage.selectRandomCountryAndCityAccordingToSelectedCountry();
        mainPage.fillInShortDescr();
        mainPage.fillInFullDescr();
        mainPage.fillInDate();
        mainPage.fillInNotesField();
        mainPage.randomlyRateHotel();
        mainPage.verifyThatNewHotelIsSavedWithNotBlankNotesField();
    }
}
