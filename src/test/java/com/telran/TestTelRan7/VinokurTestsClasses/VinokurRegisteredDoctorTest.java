
package com.telran.TestTelRan7.VinokurTestsClasses;


import com.telran.TestNgTestBase;
import com.telran.pages.TelRan7.vinokurPagesClasses.VinokurLoginPage;
import com.telran.pages.TelRan7.vinokurPagesClasses.VinokurRegisteredDoctorPage;
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

public class VinokurRegisteredDoctorTest extends TestNgTestBase {
    public static final String PASSWORD = "LinkCare!!11";
    private static final String FIRST_NAME = "Nikita1";
    private static final String LAST_NAME = "Dudikov1";
    public static final String USERNAME = FIRST_NAME + " " + LAST_NAME;
    private static final String EMAIL = LAST_NAME + "@yopmail.com";
    private static final String PERSONAL_ID = "201820743";
    private static final String CLINIC_NAME = "Marshak";
    private static final String BIRTHDAY = "11-11-1965";
    private static final String CONTACT_CELL = "0521111111";
    private static final String STREET = "Plaut";
    private static final String HOUSE_NUMBER = "10";
    private static final String CITY = "Rechovot";


   // public WebDriver driver;
    public VinokurRegisteredDoctorPage vinokurRegisteredDoctorPage;
    public VinokurLoginPage vinokurLoginPage;



    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        vinokurRegisteredDoctorPage = PageFactory.initElements(driver, VinokurRegisteredDoctorPage.class);
        vinokurLoginPage = PageFactory.initElements(driver, VinokurLoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }

    @Test (groups = {"registration","positive"})
    public void RegisteredDoctorPositiveTest() {
        vinokurRegisteredDoctorPage.registrationDoctorFillForm(USERNAME,FIRST_NAME,LAST_NAME, EMAIL,PASSWORD,
                PASSWORD,PERSONAL_ID, CLINIC_NAME,BIRTHDAY,CONTACT_CELL,STREET,HOUSE_NUMBER,CITY);
        vinokurLoginPage.WaitUntilDoctorPageIsLoaded();
        Assert.assertTrue(vinokurLoginPage.IsOnDoctorPage(),"LOGIN NOT FINISHED");
        Assert.assertEquals("יציאה", vinokurLoginPage.GetTextFromExitLink(),"LOGIN NOT FINISHED");
    }
    @Test(groups = {"registration","negative"})
    public void RegisteredDoctorWrongIDNegativeTest() {
        vinokurRegisteredDoctorPage.registrationDoctorFillForm(USERNAME,FIRST_NAME,LAST_NAME, EMAIL,PASSWORD,
                PASSWORD,"12345678", CLINIC_NAME,BIRTHDAY,CONTACT_CELL,STREET,HOUSE_NUMBER,CITY);
        vinokurLoginPage.WaitUntilDoctorPageIsLoaded();
        Assert.assertEquals("Login", vinokurLoginPage.GetTextFromExitLink(),"LOGIN FINISHED in Negative test");
    }
    @Test(groups = {"registration","negative"})
    public void RegisteredDoctorNoLastNameNegativeTest() {
        vinokurRegisteredDoctorPage.registrationDoctorFillForm(USERNAME,FIRST_NAME," ", EMAIL,PASSWORD,
                PASSWORD,PERSONAL_ID, CLINIC_NAME,BIRTHDAY,CONTACT_CELL,STREET,HOUSE_NUMBER,CITY);
        vinokurLoginPage.WaitUntilDoctorPageIsLoaded();
        Assert.assertEquals("Login", vinokurLoginPage.GetTextFromExitLink(),"LOGIN FINISHED in Negative test");
    }
    @Test(groups = {"registration","negative"})
    public void RegisteredDoctorNoEmailNegativeTest() {
        vinokurRegisteredDoctorPage.registrationDoctorFillForm(USERNAME,FIRST_NAME,LAST_NAME, EMAIL,PASSWORD,
                PASSWORD,PERSONAL_ID, CLINIC_NAME,BIRTHDAY,CONTACT_CELL,STREET,HOUSE_NUMBER,CITY);
        vinokurLoginPage.WaitUntilDoctorPageIsLoaded();
        Assert.assertEquals("Login", vinokurLoginPage.GetTextFromExitLink(),"LOGIN FINISHED in Negative test");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}


