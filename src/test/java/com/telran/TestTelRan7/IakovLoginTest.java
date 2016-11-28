package com.telran.TestTelRan7;

import com.telran.TestNgTestBase;
import com.telran.pages.TelRan7.IakovLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Iakov on 11/24/2016.
 */
public class IakovLoginTest extends TestNgTestBase {
    public WebDriver driver;
    public IakovLoginPage iakovLoginPage;

    // @BeforeClass(alwaysRun = true)
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "C://QATols//geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        iakovLoginPage = PageFactory.initElements(driver, IakovLoginPage.class);
    }

    @Test
    public void loginPositiveTest() {

        iakovLoginPage.WaitUntilLoginPageIsLoaded();
        iakovLoginPage.FillUsername("5000doctor");
        iakovLoginPage.FillPassword("LinkCare!!11");
        iakovLoginPage.ClickOnLogin();
    }

    @Test
    public void loginNegativeTest() {

        iakovLoginPage.WaitUntilLoginPageIsLoaded();
        iakovLoginPage.FillUsername("");
        iakovLoginPage.FillPassword("LinkCare!!11");
        iakovLoginPage.ClickOnLogin();
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
