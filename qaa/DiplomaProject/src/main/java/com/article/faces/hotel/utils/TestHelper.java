package com.article.faces.hotel.utils;

public class TestHelper {


    public static String getSpanLocator (String text){
        return String.format("//span[text()='%s']", text);

    }

    }
