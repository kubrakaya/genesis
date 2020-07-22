package com.mobiliz.portal.test.ui.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

    private static final Logger logger = LogManager.getLogger(CustomWait.class);

    private static final int TIMEOUT_IN_SECONDS_S = 5;
    private static final int TIMEOUT_IN_SECONDS_M = 10;

    public static void waitForElementToBeVisible(WebElement element, WebDriver driver){

        //System.out.println("waitForElementToBeVisible(WebElement element, WebDriver driver)");

        try {
            new WebDriverWait(driver, TIMEOUT_IN_SECONDS_S).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e){
            //TODO: Wait'ten dönebilecek hata türlerinin herbirini handle et
            logger.error("Exception in finding : " + element);
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeClickable(WebElement element, WebDriver driver){
        try {
            new WebDriverWait(driver, TIMEOUT_IN_SECONDS_S).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e){

            logger.error("Exception in element clickable : " + element);
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeInvisible(WebElement element, WebDriver driver){

        System.out.println("waitForElementToBeInvisible(WebElement element, WebDriver driver)");

        new WebDriverWait(driver, TIMEOUT_IN_SECONDS_M).until(ExpectedConditions.invisibilityOf(element));


    }

}