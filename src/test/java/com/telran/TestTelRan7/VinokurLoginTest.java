package com.telran.TestTelRan7;

import com.telran.TestNgTestBase;
import com.telran.pages.TelRan7.VinokurLoginPage;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by user on 27.11.2016.
 */
public class VinokurLoginTest extends TestNgTestBase{
    public WebDriver driver;
    public VinokurLoginPage vinokurLoginPage;

    @BeforeClass   //(alwaysRun = true)????
    public void setup() {
        vinokurLoginPage = PageFactory.initElements(driver, VinokurLoginPage.class);
        driver = new FirefoxDriver();
    }
    @BeforeMethod
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }
    @Test
    public void loginPositiveTest() {
        VinokurLoginPage.WaitUntilLoginPageIsLoaded();
        VinokurLoginPage.FillUsername("5000doctor");
        VinokurLoginPage.FillPassword("LinkCare!!11");
        VinokurLoginPage.ClickOnLogin();
    }
    @Test
    public void loginFullNegativeTest() {
        VinokurLoginPage.WaitUntilLoginPageIsLoaded();
        VinokurLoginPage.FillUsername("netTakogo");
        VinokurLoginPage.FillPassword("parolyaTojeNet");
        VinokurLoginPage.ClickOnLogin();
    }
    @Test
    public void loginNegativeNullUserTest() {
        VinokurLoginPage.WaitUntilLoginPageIsLoaded();
        VinokurLoginPage.FillUsername("");
        VinokurLoginPage.FillPassword("LinkCare!!11");
        VinokurLoginPage.ClickOnLogin();
    }
    @Test
    public void loginNegativeNullPasswordTest() {
        VinokurLoginPage.WaitUntilLoginPageIsLoaded();
        VinokurLoginPage.FillUsername("5000doctor");
        VinokurLoginPage.FillPassword("");
        VinokurLoginPage.ClickOnLogin();
    }
    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}

