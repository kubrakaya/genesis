package com.mobiliz.portal.test.ui.testMethods;

import com.mobiliz.portal.test.service.resource.Resources;
import com.mobiliz.portal.test.service.rest.WebServiceMethods;
import com.mobiliz.portal.test.ui.base.BasePage;
import com.mobiliz.portal.test.ui.base.BaseTest;
import com.mobiliz.portal.test.ui.common.MenuItems;
import com.mobiliz.portal.test.ui.common.ViolationTypes;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class deneme extends BaseTest {

    WebDriver driver = null;
    WebServiceMethods webServiceMethods = new WebServiceMethods();

    protected BasePage basePage;

    @BeforeClass
    public void setup() {

        System.out.println(" START setup() method ");
        super.initalizeTests();
        basePage = new BasePage(driver);

    }

    @Test
    public void goToSite() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://test.mobiliz.com.tr/ng");
        driver.close();
        Assert.assertEquals(true, true);
    }


    @Test
    public void goToSiteViaChrome() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromeDriver_2.42/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        //chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
        driver.get("https://test.mobiliz.com.tr/ng");
        driver.close();
    }

    @Test
    public void enumlariDeneme() {

        System.out.println(ViolationTypes.ASIRI_HIZ_LIMITI_IHLALI.Value);
        System.out.println(ViolationTypes.ASIRI_HIZ_LIMITI_IHLALI.Tanim);

    }


    @Test
    public void dbMethodunuDene() {

        JSONArray jsonArray = webServiceMethods.get_MobileUnits_From_ViewVMOBILEUNIT();

        for (int i = 0; i < jsonArray.length(); i++) {
            System.out.println(jsonArray.get(i));

        }
    }


    @Test
    public void dene() {
        basePage.clickOnMenuItem(MenuItems.GOSTERGELER);
        basePage.clickOnMenuItem(MenuItems.TAKIP);
        basePage.clickOnMenuItem(MenuItems.YONETIM);
    }

    @Test
    public void timeFormatDeneme() {
        //public static final String simpleDateFormat_ZFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        Date date = new Date();
        String startDateZFormat = basePage.convertDateToWantedFormat(Resources.simpleDateFormat_ZFormat, date);

    }


    @Test
    public void hashMapDene() {
        Map map1 = new HashMap();
        map1.put("PROCESSTIME", "string_processtime");
        map1.put("OUTBOUNDID", "string_OUTBOUNDID");
        map1.put("TIME", "sring_TIME");

        Map map2 = new HashMap();
        map2.put("PROCESSTIME", "string_processtime2");
        map2.put("OUTBOUNDID", "string_OUTBOUNDID2");
        map2.put("TIME", "sring_TIME2");

        List<Map> myMap = new ArrayList<Map>();
        myMap.add(map1);
        myMap.add(map2);


        for (Map map : myMap) {

            System.out.println(map);


        }
    }


}
