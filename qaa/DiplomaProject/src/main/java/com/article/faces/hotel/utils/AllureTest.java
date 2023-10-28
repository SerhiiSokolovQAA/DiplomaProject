package com.article.faces.hotel.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class AllureTest implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        System.setProperty("allure.results.directory", "allure-results//" + timestamp);
    }
}
