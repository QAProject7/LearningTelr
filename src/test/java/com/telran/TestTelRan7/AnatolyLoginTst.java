package com.telran.TestTelRan7;

import com.telran.TestNgTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.telran.pages.TelRan7.anatoly.AnatolyLoginPage;

/**
 * Created by 1 on 24.11.2016.
 */
public class AnatolyLoginTst extends TestNgTestBase {
    public WebDriver driver;
    public AnatolyLoginPage loginPage;
@BeforeClass
    public void setup(){
        loginPage = PageFactory.initElements(driver, AnatolyLoginPage.class);
        driver = new FirefoxDriver();
    }
@BeforeMethod
    public void gotoLoginPage(){
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }
@Test
     public void loginPositiveTest(){
         //driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
         loginPage.WaitLoginPageIsLoaded();
         loginPage.FillUserName("5000doctor");
         loginPage.FillPassword("LinkCare!!11");
         loginPage.LoginClick();
     }
    @Test
    public void loginNegativeTest(){
        //driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        loginPage.WaitLoginPageIsLoaded();
        loginPage.FillUserName("5000doctor");
        loginPage.FillPassword("");
        loginPage.LoginClick();
        Assert.assertFalse(loginPage.isLoginValidationMsgPresent(), "User Adding do not successful");
    }
@AfterClass
     public void tearDown(){
         this.driver.quit();
     }
}
