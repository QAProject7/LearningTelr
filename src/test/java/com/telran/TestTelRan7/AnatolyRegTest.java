package com.telran.TestTelRan7;

import com.telran.TestNgTestBase;
import com.telran.pages.TelRan7.anatoly.AnatolyDoctor;
import com.telran.pages.TelRan7.anatoly.AnatolyLoginPage;
import com.telran.pages.TelRan7.anatoly.AnatolyRegPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by 1 on 24.11.2016.
 */
public class AnatolyRegTest extends TestNgTestBase {
    public WebDriver driver;
    public AnatolyLoginPage loginPage;
    public AnatolyRegPage regPage;

@BeforeClass
    public void setup(){
        loginPage = PageFactory.initElements(driver, AnatolyLoginPage.class);
        regPage = PageFactory.initElements(driver, AnatolyRegPage.class);
        driver = new FirefoxDriver();
        //driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }
@BeforeMethod
    public void gotoLoginPage(){
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        loginPage.WaitLoginPageIsLoaded();
        loginPage.RegClick();
    }
@Test
     public void RegistrationPositiveTest(){
         //driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        String user = regPage.getRandomUser();
        AnatolyDoctor newUser = new AnatolyDoctor("Pass123", user, "Pass123", regPage.getRandomName(), regPage.getRandomName(),
                                                  user + "@mail.com", regPage.generateZeut(), "01.01.1980", "1980-01-01", "052-1234567",
                                                  "Dizengoff", "3", "Tel Aviv", "clinic1");
        regPage.AddDoctor(newUser);

        Assert.assertFalse(regPage.isOnRegistrationPage(), "");
     }

@AfterClass
     public void tearDown(){
         this.driver.quit();
     }
}
