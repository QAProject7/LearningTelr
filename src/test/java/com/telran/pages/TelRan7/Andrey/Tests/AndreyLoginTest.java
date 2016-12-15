package com.telran.pages.TelRan7.Andrey.Tests;

import com.telran.pages.TelRan7.Andrey.Pages.AndreyDoctorPage;
import com.telran.pages.TelRan7.Andrey.Pages.AndreyLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by Andrey on 28.11.2016.
 */
public class AndreyLoginTest  {

    public static String registered_username = "5555Doctor";
    public static String registered_password = "LinkCare!!11";
    public WebDriver driver;
    public AndreyLoginPage andreyLoginPage;
    public AndreyDoctorPage andreyDoctorPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        andreyLoginPage = PageFactory.initElements(driver, AndreyLoginPage.class);
        andreyDoctorPage = PageFactory.initElements(driver, AndreyDoctorPage.class);

    }

    @BeforeMethod
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }

    @Test
    public void loginPositiveTest() {
        andreyLoginPage.Login(registered_username, registered_password);
        Assert.assertEquals("יציאה", andreyDoctorPage.GettextFromExitLink(),"Error!!!");
       // AssertJUnit.assertEquals("יציאה", andreyDoctorPage.GettextFromExitLink());
        Assert.assertTrue(andreyDoctorPage.isOnDoctorPage(), "Wrong page!!!");

    }

    @Test
    public void loginNegativeTest() {
        andreyLoginPage.Login("", registered_password);
        Assert.assertTrue(andreyLoginPage.alertMessageNotValidUsername());
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}

