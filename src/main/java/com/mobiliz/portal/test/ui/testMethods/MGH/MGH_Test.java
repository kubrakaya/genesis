package com.mobiliz.portal.test.ui.testMethods.MGH;

import com.mobiliz.portal.test.ui.base.BasePage;
import com.mobiliz.portal.test.ui.base.BaseTest;
import com.mobiliz.portal.test.ui.base.UiResources;
import com.mobiliz.portal.test.ui.common.MenuItems;
import com.mobiliz.portal.test.ui.common.ModulesUnderYonetimMenu;
import com.mobiliz.portal.test.ui.common.TabNames;
import com.mobiliz.portal.test.ui.page.MGH.MGH_Page;
import com.mobiliz.portal.test.ui.page.curtain.Curtain;
import com.mobiliz.portal.test.ui.page.login.LoginPage;
import com.mobiliz.portal.test.ui.testMethods.login.LoginTest;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;


public class MGH_Test extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    protected LoginPage loginPage;
    protected Curtain curtain;
    protected BasePage basePage;
    protected MGH_Page mgh_Page;

    @BeforeClass
    public void setup() {


        super.initalizeTests();
        loginPage = new LoginPage(driver);
        curtain = new Curtain(driver);
        basePage = new BasePage(driver);
        mgh_Page = new MGH_Page(driver);
    }

    @BeforeMethod
    public void goToMobilGuvenlikHizmetleriModule() {

        loginPage.getLoginPage();

        loginPage.login(UiResources.USERNAME, UiResources.PASSWORD);

        basePage.hoverMenuToggleButton();

        basePage.clickOnMenuItem(MenuItems.YONETIM);

        Assert.assertTrue(basePage.isYonetimMenuOpened());

        basePage.clickOnModule_UnderYonetimMenu(ModulesUnderYonetimMenu.MOBIL_GUVENLIK_HIZMETLERI);

        Assert.assertTrue(mgh_Page.isMobilGuvenlikHizmetleriModuleOpened());
    }

    //TODO:  BeforeMethod değil ama, diğer test methodları exception attığında,exception atan methottan boolean false return edip
    //TODO:  Assert.Fail diyerek o test metotunu fail olarak işaretleyip, diğer metotların koşturulmaya devam etmesini sağlamak
    @Test
    public void checkAracYetkilendirmeTabIsOpened() {

        System.out.println("the method 'checkAracYetkilendirmeTabIsOpened()' STARTS... ");

        basePage.clickOnTab(TabNames.MGH_ARAC_YETKILENDIRME);


        //Assert.assertTrue( mgh_Page.isAracYetkilendirmeTabIsOpened());

        Assert.assertTrue(false);

    }

    @Test
    public void checkTest()
    {
        Assert.assertTrue(true);

        Assert.assertTrue(loginPage.logout());
    }

    @AfterClass
    public void afterLoginTests() {

        super.finalizeTests();
        //Assert.assertTrue( loginPage.logout());
    }


}
