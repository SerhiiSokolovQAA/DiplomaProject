package com.article.faces.hotel.tests;

import com.article.faces.hotel.page.MainPage;
import com.article.faces.hotel.utils.SetUpClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewHotelPageTests extends SetUpClass {



    @Test
    public void testCanOpenRegisterNewHotelPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isRegisterNewHotelPage(), "Verify that Register new Hotel page is displayed when the user selects Article->New->Hotel");
    }

    @Test
    public void verifyDataSectionIsDisplayedOnRegisterNewHotelPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isDataSectionVisible(), "Verify that Data section is displayed on Register New Hotel");
    }

    @Test
    public void verifySaveButtonIsDisplayedOnRegisterNewHotelPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openNewHotelPage();
        Assert.assertTrue(mainPage.isSaveButtonDisplayed(), "Verify that save button is displayed on Register new Hotel");
    }

}
