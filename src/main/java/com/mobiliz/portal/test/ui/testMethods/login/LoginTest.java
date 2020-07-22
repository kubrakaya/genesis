package com.mobiliz.portal.test.ui.testMethods.login;

import com.mobiliz.portal.test.ui.base.BasePage;
import com.mobiliz.portal.test.ui.base.BaseTest;
import com.mobiliz.portal.test.ui.base.UiResources;
import com.mobiliz.portal.test.ui.common.MenuItems;
import com.mobiliz.portal.test.ui.common.ModulesUnderYonetimMenu;
import com.mobiliz.portal.test.ui.page.curtain.Curtain;
import com.mobiliz.portal.test.ui.page.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    protected LoginPage loginPage;
    protected Curtain curtain;
    protected BasePage basePage;
 

    @BeforeClass
    public void setup() {

        System.out.println(" START setup() method in LoginTest.java");

        super.initalizeTests();
        loginPage = new LoginPage(driver);
        curtain = new Curtain(driver);
        basePage = new BasePage(driver);
    }

    @Test
    public void isLoggedInSuccessful() {

        logger.info("START isLoggedInSuccessful()...");

        loginPage.getLoginPage();

        System.out.println("isLoggedInSuccessful 2. satir");

        loginPage.login(UiResources.USERNAME, UiResources.PASSWORD);

        Assert.assertEquals(loginPage.isLoggedIn(), MenuItems.GOSTERGELER.Tanim);


    }


    @Test
    public void deneme()
    {
        System.out.println(ModulesUnderYonetimMenu.TEMEL_ISLEVLER);
        System.out.println( ModulesUnderYonetimMenu.valueOf("TEMEL_ISLEVLER"));
        System.out.println(MenuItems.GOSTERGELER.Attribute_ID);
        System.out.println(MenuItems.GOSTERGELER.getAttribute_ID());


    }

    @Test
    public void deneme2()
    {

    }

    @AfterClass
    public void afterLoginTests() {

        super.finalizeTests();
    }

}
