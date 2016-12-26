package com.telran.pages.TelRan7.napris;

import com.telran.LogLog4j;
import com.telran.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Napris on 04.12.2016.
 */
public class NaprisDoctorPage extends Page {
    private static Logger log = Logger.getLogger(LogLog4j.class.getName());
    //fields

    //buttons

    //elements
    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement exitLink;

    @FindBy(id = "ctl00_DisplayImportantLinks1_myMenu")
    WebElement doctorsLeftMenu;

    @FindBy(id = "Top1_HeadLoginView_DisplayName")
    WebElement doctorsFullnameElement;


    //constructor
    public NaprisDoctorPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        // this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SecurityInfrastructure/Accounts.aspx";
        PageFactory.initElements(driver, this);
    }

    //methods
    //  public boolean isOnDoctorPage() {  //method not correct because exitLink exist in LoginPage and in DoctorPage(change only innerText)
    //      return exists(exitLink);
    //  }
    public boolean isOnDoctorPage() {
        return exists(doctorsFullnameElement);
    }

    public String getTextFromExitLink() {
        return exitLink.getText();
    }

    public void waitUntilDoctorPageIsLoaded() {
        waitUntilIsLoadedCustomTime(doctorsLeftMenu, 10);
        log.info("Waiting 10sec until Doctor Page is loaded");
    }

    public String getTextFromDoctorsFullnameElement() {
        return doctorsFullnameElement.getText();
    }
}
