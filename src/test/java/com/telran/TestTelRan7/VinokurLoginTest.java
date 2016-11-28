package com.telran.TestTelRan7;

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
public class VinokurLoginTest{
    public WebDriver driver;
    public VinokurLoginPage vinokurLoginPage;

    @BeforeClass   //(alwaysRun = true)????
    public void setup() {

        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\user\\Documents\\IdeaProjects\\geckodriver-v0.11.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        vinokurLoginPage = PageFactory.initElements(driver, VinokurLoginPage.class);
    }
    @BeforeMethod
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }
    @Test
    public void loginPositiveTest() {
        vinokurLoginPage.WaitUntilLoginPageIsLoaded();
        vinokurLoginPage.FillUsername("5000doctor");
        vinokurLoginPage.FillPassword("LinkCare!!11");
        vinokurLoginPage.ClickOnLogin();
    }
    @Test
    public void loginFullNegativeTest() {
        vinokurLoginPage.WaitUntilLoginPageIsLoaded();
        vinokurLoginPage.FillUsername("netTakogo");
        vinokurLoginPage.FillPassword("parolyaTojeNet");
        vinokurLoginPage.ClickOnLogin();
    }
    @Test
    public void loginNegativeNullUserTest() {
        vinokurLoginPage.WaitUntilLoginPageIsLoaded();
        vinokurLoginPage.FillUsername("");
        vinokurLoginPage.FillPassword("LinkCare!!11");
        vinokurLoginPage.ClickOnLogin();
    }
    @Test
    public void loginNegativeNullPasswordTest() {
        vinokurLoginPage.WaitUntilLoginPageIsLoaded();
        vinokurLoginPage.FillUsername("5000doctor");
        vinokurLoginPage.FillPassword("");
        vinokurLoginPage.ClickOnLogin();
    }
    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}

