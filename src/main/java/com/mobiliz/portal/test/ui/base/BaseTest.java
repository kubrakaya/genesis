package com.mobiliz.portal.test.ui.base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected static WebDriver driver = null;

    public void initalizeTests() {

        try {

            System.out.println("initalizeTests() method in BaseTest.java");

            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();

            //System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromeDriverDir_2.42/chromedriver.exe");
            //driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception ex) {
            System.out.println("ex = " + ex);
        }
    }


    public void finalizeTests() {

        driver.close();


    }

}

