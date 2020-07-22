package com.mobiliz.portal.test.ui.page.login;

import com.google.common.util.concurrent.Uninterruptibles;
import com.mobiliz.portal.test.ui.base.BasePage;
import com.mobiliz.portal.test.ui.common.CustomWait;
import com.mobiliz.portal.test.ui.page.curtain.Curtain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(css = "input[id='username']")
    private WebElement usernameInput;

    @FindBy(css = "input[id='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[id='login-btn']")
    private WebElement signInButton;

    @FindBy(css = "h2[class='section-name ng-binding']")
    private WebElement GOSTERGELER_h2_webElement;


    public void getLoginPage() {

        System.out.println("the method 'getLoginPage()' STARTS...");

        driver.get("https://test.mobiliz.com.tr/ng");

        //driver.get("http://192.168.4.15:8081/");

        Curtain.waitUntilCurtainGoOn(driver);

    }

    public void waitForPageLoading() {

        logger.debug("Waiting for page to load...");
        CustomWait.waitForElementToBeClickable(signInButton, driver);
    }


    public void enterUsername(String username) {

        if (username == null) {
            throw new IllegalArgumentException("Passed parameter `username` can not be null!");
        }

        new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(usernameInput));

        logger.debug("Entering username...");

        usernameInput.sendKeys(username);

    }


    public void enterPassword(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Passed parameter `password` can not be null!");
        }

        new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOf(passwordInput));

        logger.debug("Entering password...");

        passwordInput.sendKeys(password);

    }

    public void clickSignInButton() {
        logger.debug("Clicking sign in button...");
        signInButton.click();
    }

    public void login(String username, String password) {
        try {

            enterLoginCredentials(username, password);
            clickSignInButton();


        } catch (Exception ex) {
            logger.info("Error at the login(String username, String password))");
            System.out.println(ex.getMessage());
        }
    }


    public boolean logout() {

        boolean result = false;

        System.out.println("the method logout() STARTS...");

        IsLabelLutfenBekleyinizGone();

        clickOnProfileButton();

        result = IsProfileMenuIsDisplayed();

        return result;

    }

    public boolean IsProfileMenuIsDisplayed() {

        System.out.println("the method IsProfileMenuIsDisplayed() STARTS...");

        //to check whether it exists in DOM or not

        boolean IsExist;
        IsExist = driver.findElements(By.tagName("mc-dropdown")).size() != 0;

        System.out.println("1 IsExist : " + IsExist);

        if (IsExist) {

            System.out.println("if(IsExist)");
            WebElement webElementProfileMenu = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.tagName("mc-dropdown")));

            System.out.println("webElementProfileMenu.isDisplayed() : " + webElementProfileMenu.isDisplayed());

            //DOM da exist olmasına değil, ekranda da görünür olup olmadığını kontrol eder
            return webElementProfileMenu.isDisplayed();
        }

        System.out.println("before return IsExist : " + IsExist);
        return IsExist;
    }

    /**
     * Kullanıcı isminin ve ünvanının yazılı olduğu ekranın sağ üst köşesindeki profil butonuna tıklamayı sağlayan methoddur.
     */
    public void clickOnProfileButton() {

        System.out.println("the method clickProfileButton() STARTS...");

        WebElement ProfileButton = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='header-control-btn ng-binding']")));

        ProfileButton.click();


    }

    public String isLoggedIn() {

        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(GOSTERGELER_h2_webElement));

        return GOSTERGELER_h2_webElement.getText();

    }

    public void enterLoginCredentials(String username, String password) {

        logger.debug("START enterLoginCredentials()");

        waitForPageLoading();

        enterUsername(username);

        enterPassword(password);
    }
}


