package com.telran.pages.TelRan7.Andrey.Tests;

import com.telran.pages.TelRan7.Andrey.Pages.AndreyDoctorRegistrationPage;
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
public class AndreyDoctorRegistrationTest {

    public static final String PASSWORD = "LinkCare!!11";
    private static final String FIRST_NAME = "Anton";
    private static final String LAST_NAME = "Pupkin";
    public static final String USERNAME = FIRST_NAME + " " + LAST_NAME;
    private static final String EMAIL = "Forse1938@gustr.com";
    private static final String PERSONAL_ID = "155967458";
    private static final String CLINIC_NAME = "rwre";
    private static final String BIRTHDAY = "12.05.1975";
    private static final String TELEPHONE = "0349559595";
    private static final String STREET = "Hercel";
    private static final String HOUSE_NUMBER = "7";
    private static final String CITY = "TelAviv";

    public WebDriver driver;
    public AndreyLoginPage loginPage;
    public AndreyDoctorRegistrationPage regPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, AndreyLoginPage.class);
        regPage = PageFactory.initElements(driver, AndreyDoctorRegistrationPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        loginPage.WaitUntilLoginPageIsLoaded();
        loginPage.ClickOnGoToRegistrPageButton();

    }

    @Test
    public void registrDoctor() {
//        regPage.AddNewDoctor(USERNAME,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,PASSWORD,STREET,HOUSE_NUMBER,
//                             BIRTHDAY,CITY,PERSONAL_ID,CLINIC_NAME,TELEPHONE);
        regPage.WaitRegPageIsLoaded();
        Assert.assertTrue(regPage.isOnRegistrationPage(), "Wrong page!!!");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }

}
