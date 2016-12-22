package com.telran.TestTelRan7;

import com.telran.TestNgTestBase;
import com.telran.pages.TelRan7.IakovDoctorPage;
import com.telran.pages.TelRan7.IakovLoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Iakov on 11/24/2016.
 */
public class IakovLoginTest extends TestNgTestBase {
    // public WebDriver driver;
    public IakovLoginPage iakovLoginPage;
    public IakovDoctorPage iakovDoctorPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {

        // System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        // driver = new FirefoxDriver();
        iakovLoginPage = PageFactory.initElements(driver, IakovLoginPage.class);
        iakovDoctorPage = PageFactory.initElements(driver, IakovDoctorPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il");

    }

    @Test(groups = {"login", "positive"})
    public void loginPositiveTest() {

        iakovLoginPage.WaitUntilLoginPageIsLoaded();
        iakovLoginPage.FillUsername("5555Doctor");
        iakovLoginPage.FillPassword("LinkCare!!11");
        iakovLoginPage.ClickOnLogin();
        iakovDoctorPage.WaitUntilDoctorPageIsLoaded();
       //  COMMITTED BY VINOKUR AssertJUnit.assertEquals("יציאה", iakovDoctorPage.GettextFromExitLink()5);
        Assert.assertEquals("יציאה", iakovDoctorPage.GettextFromExitLink(), "this link do not exists");

        // .assertTrue(iakovLoginPage.isOnDoctorPage(),"We are not on doctor's page");
    }

    @Test(groups = {"login", "negative"})
    public void loginNegativeTest() {

        iakovLoginPage.WaitUntilLoginPageIsLoaded();
        iakovLoginPage.FillUsername("");
        iakovLoginPage.FillPassword("LinkCare!!11");
        iakovLoginPage.ClickOnLogin();
    }

    //@AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
