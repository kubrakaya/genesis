package com.mobiliz.portal.test.ui.base;


import com.google.common.util.concurrent.Uninterruptibles;
import com.mobiliz.portal.test.ui.common.MenuItems;
import com.mobiliz.portal.test.ui.common.ModulesUnderYonetimMenu;
import com.mobiliz.portal.test.ui.common.TabNames;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//Uninterruptibles.sleepUninterruptibly(90000, TimeUnit.MILLISECONDS);
public class BasePage {


    protected static WebDriver driver;


    public BasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public BasePage()
    {


    }

    public Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public Date takeDate3HoursAhead(Date date) {

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, +3);
        return calendar.getTime();
    }

    public Date takeDate7MonthsBack(Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //calendar.add(Calendar.DATE,-60);
        calendar.add(Calendar.MONTH, -7);
        return calendar.getTime();
    }

    public String convertDateToWantedFormat(String dateFormat, Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return (simpleDateFormat.format(date));

    }

    public void clickOnMenuItem(MenuItems menuItems) {

        System.out.println("the method 'clickOnMenuItem()' STARTS...");

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id(menuItems.getAttribute_ID())));

        WebElement webElement = driver.findElement(By.id(menuItems.getAttribute_ID()));

        webElement.click();

    }

    public boolean isYonetimMenuOpened() {

        System.out.println("the method 'isYonetimMenuOpened()' STARTS...");

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ModulesUnderYonetimMenu.TEMEL_ISLEVLER.getCssSelector())));
        String menuItemText = driver.findElement(By.cssSelector((ModulesUnderYonetimMenu.TEMEL_ISLEVLER.getCssSelector()))).getText();

        System.out.println("Uninterruptibles.sleepUninterruptibly(90000, TimeUnit.MILLISECONDS);");

        Uninterruptibles.sleepUninterruptibly(90000, TimeUnit.MILLISECONDS);

        System.out.println("Uninterruptibles end");

        return (menuItemText.equals(ModulesUnderYonetimMenu.TEMEL_ISLEVLER.getTanim()) ? true : false);
    }

    /**
     * Bu method Yönetim ekranındaki modüllerden birine tıklamayı sağlıyor
     *
     * @param modulesUnderYonetim
     */
    public void clickOnModule_UnderYonetimMenu(ModulesUnderYonetimMenu modulesUnderYonetim) {

        System.out.println("the method 'clickOnModule_UnderYonetim()' STARTS...");

        IsLabelLutfenBekleyinizGone();

        String css_body = "body.block-ui-active.block-ui-visible";
        boolean in = new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css_body)));

        String ID_tag_li_mobilGuvenlikModule = "management-menu-item--management.mobile-security-services";
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id(ID_tag_li_mobilGuvenlikModule)));
        WebElement webElement = driver.findElement(By.id(ID_tag_li_mobilGuvenlikModule));
        webElement.click();

    }

    public boolean IsLabelLutfenBekleyinizGone() {

        System.out.println("the mmethod IsLabelLutfenBekleyinizGone() STARTS...");

        //Ekranda lütfen bekleyiniz yazısı görüntülendiğinde body kısmına block-ui-active ve diğer class ekleniyor.Yazı kaybolduğunda,class lar da kaldırılıyor.
        String css_body = "body.block-ui-active.block-ui-visible";

        boolean labelLutfenBekleyinizGittiMi = new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css_body)));

        return labelLutfenBekleyinizGittiMi;
    }

    public void clickOnTab(TabNames tabNames) {

        try {

            System.out.println("the method 'clickOnTab()' STARTS...");

            IsLabelLutfenBekleyinizGone();

            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(tabNames.getCssSelectorDef())));

            WebElement element = driver.findElement(By.cssSelector(tabNames.getCssSelectorDef()));

            element.click();


        } catch (Exception ex) {
            System.out.println(ex);
        }


    }

    //TODO : Bazen button[class=header-control-btn] component ını bulamıyor
    public boolean hoverMenuToggleButton() {
        try {

            System.out.println("the method 'hoverMenuToggleButton()' STARTS...");

            IsLabelLutfenBekleyinizGone();

            By BySelectorMenuToggleButton = By.cssSelector("button[class=header-control-btn]");

            if (BySelectorMenuToggleButton == null) {
                return false;
            }

            try {

                new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(BySelectorMenuToggleButton));

                Actions action = new Actions(driver);
                WebElement menuToggleButtonWebElement = driver.findElement(By.cssSelector("button[class=header-control-btn]"));
                action.moveToElement(menuToggleButtonWebElement).perform();

            } catch (Exception e) {

                Assert.fail("Element not found to hover it in the method 'hoverMenuToggleButton' e.getMessage() =  " + e.getMessage());

            }

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        } finally {
            return true;
        }


    }


}
