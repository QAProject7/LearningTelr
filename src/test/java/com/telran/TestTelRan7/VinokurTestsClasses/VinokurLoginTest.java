
package com.telran.TestTelRan7.VinokurTestsClasses;

import com.telran.pages.TelRan7.vinokurPagesClasses.VinokurLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Vinokur on 27.11.2016.
 */

public class VinokurLoginTest{
    public WebDriver driver;
    public VinokurLoginPage vinokurLoginPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {

        System.setProperty("webdriver.gecko.driver",
                "src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        vinokurLoginPage = PageFactory.initElements(driver, VinokurLoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }

    @Test (groups = {"login","positive"})
    public void loginPositiveTest() {
        vinokurLoginPage.WaitUntilLoginPageIsLoaded();
        vinokurLoginPage.FillUsername("5555Doctor");
        vinokurLoginPage.FillPassword("LinkCare!!11");
        vinokurLoginPage.ClickOnLogin();
        vinokurLoginPage.WaitUntilDoctorPageIsLoaded();
        Assert.assertTrue(vinokurLoginPage.IsOnDoctorPage(),"login NOT FINISHED");
        Assert.assertEquals("יציאה", vinokurLoginPage.GetTextFromExitLink(),"login NOT FINISHED");
    }
    @Test (groups = {"login","negative"})
    public void loginFullNegativeTest() {
        vinokurLoginPage.WaitUntilLoginPageIsLoaded();
        vinokurLoginPage.FillUsername("netTakogo");
        vinokurLoginPage.FillPassword("parolyaTojeNet");
        vinokurLoginPage.ClickOnLogin();
        vinokurLoginPage.WaitUntilDoctorPageIsLoaded();
        Assert.assertEquals("Login", vinokurLoginPage.GetTextFromExitLink(),"login FINISHED in Negative test");

    }
    @Test(groups = {"login","negative"})
    public void loginNegativeNullUserTest() {
        vinokurLoginPage.WaitUntilLoginPageIsLoaded();
        vinokurLoginPage.FillUsername("");
        vinokurLoginPage.FillPassword("LinkCare!!11");
        vinokurLoginPage.ClickOnLogin();
        vinokurLoginPage.WaitUntilDoctorPageIsLoaded();
        Assert.assertEquals("Login", vinokurLoginPage.GetTextFromExitLink(),"login FINISHED in Negative test");
    }
    @Test(groups = {"login","negative"})
    public void loginNegativeNullPasswordTest() {
        vinokurLoginPage.WaitUntilLoginPageIsLoaded();
        vinokurLoginPage.FillUsername("5000doctor");
        vinokurLoginPage.FillPassword("");
        vinokurLoginPage.ClickOnLogin();
        vinokurLoginPage.WaitUntilDoctorPageIsLoaded();
        Assert.assertEquals("Login", vinokurLoginPage.GetTextFromExitLink(),"login FINISHED in Negative test");
    }
    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}


