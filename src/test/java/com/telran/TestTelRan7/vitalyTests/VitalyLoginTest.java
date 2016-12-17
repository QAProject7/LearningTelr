package com.telran.TestTelRan7.vitalyTests;


import com.telran.TestNgTestBase;
import com.telran.pages.TelRan7.vitalyPages.VitalyDoctorPage;
import com.telran.pages.TelRan7.vitalyPages.VitalyDoctorRegistrationPage;
import com.telran.pages.TelRan7.vitalyPages.VitalyLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Vitaly on 28.11.2016.
 */
public class VitalyLoginTest   {

    public VitalyLoginPage vitalyLoginPage;
    public VitalyDoctorPage vitalyDoctorPage;
     public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {

          System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
         driver = new FirefoxDriver();
        vitalyLoginPage = PageFactory.initElements(driver, VitalyLoginPage.class);
        vitalyDoctorPage = PageFactory.initElements(driver, VitalyDoctorPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");

    }

    @Test(groups = {"login ","positive"})
    public void loginPositiveTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("5555Doctor");
        vitalyLoginPage.FillPassword("LinkCare!!11");
        vitalyLoginPage.ClickLogIn();
        vitalyDoctorPage.waitUntilDoctorsPageIsLoaded();
        Assert.assertTrue(vitalyDoctorPage.isOnDoctorPage(), "We are not on doctor`s page");
        Assert.assertEquals("יציאה", vitalyDoctorPage.getTextFromExitLink());
        AssertJUnit.assertEquals("יציאה", vitalyDoctorPage.getTextFromExitLink());
    }


    @Test(groups = {"login ","negative"})
    public void loginNegativeTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("123");
        vitalyLoginPage.FillPassword("456");
        vitalyLoginPage.ClickLogIn();
        Assert.assertEquals(vitalyDoctorPage.getTextFromExitLink(), "Login");
    }

    @Test(groups = {"login ","negative"})
    public void loginNullUserNameTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName(" ");
        vitalyLoginPage.FillPassword("LinkCare!!11");
        vitalyLoginPage.ClickLogIn();
        Assert.assertEquals(vitalyDoctorPage.getTextFromExitLink(), "Login");
    }

    @Test(groups = {"login ","negative"})
    public void loginNullPasswordTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("5555Doctor");
        vitalyLoginPage.FillPassword("");
        vitalyLoginPage.ClickLogIn();
        Assert.assertEquals(vitalyDoctorPage.getTextFromExitLink(), "Login");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }

}
