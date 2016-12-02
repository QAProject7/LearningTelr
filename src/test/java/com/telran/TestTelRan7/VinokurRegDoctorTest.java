package com.telran.TestTelRan7;

import com.telran.TestNgTestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Vinokur on 27.11.2016.
 */
public class VinokurRegDoctorTest extends TestNgTestBase {
    public VinokurRegDoctorTest vinokurRegDoctorTest;








    @BeforeClass   (alwaysRun = true)
    public void setup() {
        vinokurRegDoctorTest = PageFactory.initElements(driver, VinokurRegDoctorTest.class);
        driver = new FirefoxDriver();
    }
    @BeforeMethod
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }
    @Test
    public void loginPositiveTest() {

    }
}
