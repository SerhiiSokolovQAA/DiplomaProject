package com.article.faces.hotel.utils;

import com.article.faces.hotel.page.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SetUpClass {
    public WebDriver driver;
    private MainPage mainPage;


    @BeforeMethod
    public void setUp() {
        Properties prop = new Properties();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream input = classLoader.getResourceAsStream("properties/properties.properties");
            prop.load(input);
            String chromedriverPath = prop.getProperty("chromedriver.path");
            System.setProperty("webdriver.chrome.driver", chromedriverPath);
            driver = new ChromeDriver();
            driver.navigate().to(System.getenv("BASE_HOTEL_URL"));
            driver.manage().window().maximize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
