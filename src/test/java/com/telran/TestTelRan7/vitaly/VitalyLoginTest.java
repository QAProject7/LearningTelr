package com.telran.TestTelRan7.vitaly;


import com.telran.pages.TelRan7.VitalyLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by vitaliy on 28.11.2016.
 */
public class VitalyLoginTest {

    public VitalyLoginPage vitalyLoginPage;
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        vitalyLoginPage = PageFactory.initElements(driver, VitalyLoginPage.class);
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dashu\\Documents\\IdeaProjects\\LearningTelr\\Path\\geckodriver-v0.11.1-win32\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");

    }

    @Test
    public void loginPositiveTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("5000doctor");
        vitalyLoginPage.FillPassword("LinkCare!!11");
        vitalyLoginPage.ClickLogIn();
    }

    @Test
    public void loginNegativeTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("123");
        vitalyLoginPage.FillPassword("456");
        vitalyLoginPage.ClickLogIn();
    }

    @Test
    public void loginNullUserNameTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName(" ");
        vitalyLoginPage.FillPassword("LinkCare!!11");
        vitalyLoginPage.ClickLogIn();
    }

    @Test
    public void loginNullPasswordTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("5000doctor");
        vitalyLoginPage.FillPassword("");
        vitalyLoginPage.ClickLogIn();
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
