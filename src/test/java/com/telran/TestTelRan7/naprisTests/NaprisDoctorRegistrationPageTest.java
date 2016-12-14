package com.telran.TestTelRan7.naprisTests;

import com.telran.pages.TelRan7.NaprisDoctorRegistrationPage;
import com.telran.pages.TelRan7.napris.NaprisDoctorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Napris on 27.11.2016.
 */
public class NaprisDoctorRegistrationPageTest {
    public static final String PASSWORD = "LinkCare!!11";
    private static final String FIRST_NAME = "Ivan";
    private static final String LAST_NAME = "Ivanoff";
    public static final String USERNAME = FIRST_NAME + " " + LAST_NAME;
    private static final String EMAIL = "iivanov@yopmail.com";
    private static final String PERSONAL_ID = "759032675";
    private static final String CLINIC_NAME = USERNAME;
    private static final String BIRTHDAY = "11/11/1965";
    private static final String CONTACT_CELL = "0521111111";
    private static final String STREET = "Plaut";
    private static final String HOUSE_NUMBER = "10";
    private static final String CITY = "Rechovot";


    public WebDriver driver;
    public NaprisDoctorRegistrationPage naprisDoctorRegistrationPage;
    public NaprisDoctorPage doctorPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
        driver = new FirefoxDriver();
        naprisDoctorRegistrationPage = PageFactory.initElements(driver, NaprisDoctorRegistrationPage.class);
        doctorPage = PageFactory.initElements(driver, NaprisDoctorPage.class);
    }

    @BeforeMethod
    public void goToLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }

    @Test(groups = {"doctorRegistration", "positive"})
    public void DoctorRegistrationTest() {
        naprisDoctorRegistrationPage.doctorRegistration(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD,
                PERSONAL_ID, CLINIC_NAME, BIRTHDAY, CONTACT_CELL, STREET, HOUSE_NUMBER, CITY);
        doctorPage.waitUntilDoctorPageIsLoaded();
        assertTrue(doctorPage.isOnDoctorPage());
        assertEquals(doctorPage.getTextFromExitLink(), "יציאה");
        assertEquals(doctorPage.getTextFromDoctorsFullnameElement(), FIRST_NAME + " " + LAST_NAME);

    }

    @Test(groups = {"doctorRegistration", "negative"})
    public void DoctorRegistrationWithoutIDTest() {
        naprisDoctorRegistrationPage.doctorRegistration(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD,
                "", CLINIC_NAME, BIRTHDAY, CONTACT_CELL, STREET, HOUSE_NUMBER, CITY);
        doctorPage.waitUntilDoctorPageIsLoaded();
        assertEquals(doctorPage.getTextFromExitLink(), "Login");
        assertFalse(doctorPage.isOnDoctorPage());
    }


    @Test(groups = {"doctorRegistration", "negative"})
    public void DoctorRegistrationWithWrongIDTest() {
        naprisDoctorRegistrationPage.doctorRegistration(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD,
                "111111111", CLINIC_NAME, BIRTHDAY, CONTACT_CELL, STREET, HOUSE_NUMBER, CITY);
        doctorPage.waitUntilDoctorPageIsLoaded();
        assertEquals(doctorPage.getTextFromExitLink(), "Login");
        assertFalse(doctorPage.isOnDoctorPage());
    }

    @Test(groups = {"negative"})
    public void DoctorRegistrationWithoutUsernameTest() {
        naprisDoctorRegistrationPage.doctorRegistration("", FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD,
                PERSONAL_ID, CLINIC_NAME, BIRTHDAY, CONTACT_CELL, STREET, HOUSE_NUMBER, CITY);
        doctorPage.waitUntilDoctorPageIsLoaded();
        assertEquals(doctorPage.getTextFromExitLink(), "Login");
        assertFalse(doctorPage.isOnDoctorPage());
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }

}
