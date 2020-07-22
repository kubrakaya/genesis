package com.mobiliz.portal.test.ui.page.curtain;

import com.mobiliz.portal.test.ui.base.BasePage;


import com.mobiliz.portal.test.ui.common.CustomWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Curtain extends BasePage {

    @FindBy(css = "div[class='application-view ng-scope']")
    private static WebElement application;


    public Curtain(WebDriver driver) {

        super(driver);
    }

    public static void waitUntilCurtainGoOn(WebDriver driver) {

        CustomWait.waitForElementToBeVisible(application, driver);

    }

}
