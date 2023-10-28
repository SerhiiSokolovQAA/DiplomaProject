package com.article.faces.hotel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class RegisterHotelPage {
    private WebDriver driver;
    public RegisterHotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

}
