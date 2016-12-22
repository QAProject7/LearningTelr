package com.telran.TestTelRan7.naprisTests;

import com.telran.TestNgTestBase;
import com.telran.pages.TelRan7.napris.NaprisDoctorPage;
import com.telran.pages.TelRan7.napris.NaprisLoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;


/**
 * Created by Napris on 27.11.2016.
 */
public class NaprisLoginPageTest extends TestNgTestBase {
    public static final String DEFAULT_USERNAME = "Doctor";
    public static final String DEFAULT_PASSWORD = "LinkCare!!11";
    //public WebDriver driver;
    public NaprisLoginPage naprisloginPage;
    public NaprisDoctorPage doctorPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
        //driver = new FirefoxDriver();
        naprisloginPage = PageFactory.initElements(driver, NaprisLoginPage.class);
        doctorPage = PageFactory.initElements(driver, NaprisDoctorPage.class);
        driver.get(baseUrl + "/Login.aspx");
    }

    @BeforeMethod(alwaysRun = true)
    public void goToLoginPage() {

    }

    @Test(groups = {"login", "positive"})
    public void loginTest() {
        naprisloginPage.login(DEFAULT_USERNAME, DEFAULT_PASSWORD);
        doctorPage.waitUntilDoctorPageIsLoaded();
        //assertTrue(doctorPage.isOnDoctorPage(),"We are not on Doctor page");
        AssertJUnit.assertEquals("יציאה", doctorPage.getTextFromExitLink());
        assertEquals(doctorPage.getTextFromExitLink(), "יציאה");
    }

    @Test(groups = {"login", "negative"})
    public void loginWithoutUsernameTest() {
        naprisloginPage.login("", DEFAULT_PASSWORD);
        doctorPage.waitUntilDoctorPageIsLoaded();
        AssertJUnit.assertEquals("Login", doctorPage.getTextFromExitLink());
    }

    @Test(groups = {"login", "negative"})
    public void loginWithoutPasswordTest() {
        naprisloginPage.login(DEFAULT_USERNAME, "");
        doctorPage.waitUntilDoctorPageIsLoaded();
        AssertJUnit.assertEquals("Login", doctorPage.getTextFromExitLink());
    }

    @Test(groups = {"login", "negative"})
    public void loginWithoutUsernameAndPasswordTest() {
        naprisloginPage.login("", "");
        doctorPage.waitUntilDoctorPageIsLoaded();
        AssertJUnit.assertEquals("Login", doctorPage.getTextFromExitLink());
    }

    //@AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
