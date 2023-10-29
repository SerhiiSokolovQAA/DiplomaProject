package com.article.faces.hotel;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        monochrome = true,
        tags = "@CityField",
        glue={"com.article.faces.hotel"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
