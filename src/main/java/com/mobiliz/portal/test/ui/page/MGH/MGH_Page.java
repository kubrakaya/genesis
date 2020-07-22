package com.mobiliz.portal.test.ui.page.MGH;

import com.mobiliz.portal.test.ui.base.BasePage;
import com.mobiliz.portal.test.ui.common.TabNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MGH_Page extends BasePage {


    public MGH_Page(WebDriver webDriver) {
        super(driver);
    }


    public boolean isMobilGuvenlikHizmetleriModuleOpened() {


        System.out.println("the method 'isMobilGuvenlikHizmetleriModuleOpened()' STARTS...");

        IsLabelLutfenBekleyinizGone();

        String cssSelector_tag_li_alarmIzlemeTab = "mss-management > .l-tab > ul > li:nth-child(1) > a";

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector_tag_li_alarmIzlemeTab)));

        WebElement we_AlarmIzlemeTab = driver.findElement(By.cssSelector(cssSelector_tag_li_alarmIzlemeTab));

        boolean result = (we_AlarmIzlemeTab.getText().equals(TabNames.MGH_ALARM_IZLEME.getTanim()) ? true : false);

        return result;
    }

    public boolean isAracYetkilendirmeTabIsOpened() {

        System.out.println("the method 'isAracYetkilendirmeTabIsOpened()' STARTS...");

        try {
            WebElement aracYetkilendirmeComponent = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.nav-panel.ng-scope"))).findElement(By.tagName("mss-vehicle-authentication"));

            boolean z = driver.findElement(By.cssSelector("div.nav-panel.ng-scope")).findElements(By.tagName("mss-vehicle-authentication")).size() != 0;

            System.out.println("z : " + z);

            boolean IsAracYetkilendirmeTabIsNotOpened = new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(aracYetkilendirmeComponent));

            System.out.println("isAracYetkilendirmeTabIsNotOpened = " + IsAracYetkilendirmeTabIsNotOpened);

            return !IsAracYetkilendirmeTabIsNotOpened;


        } catch (Exception ex) {

            System.out.println("exception is thrown, ex message  : " + ex.getMessage());

            return false;
        }


    }


}
