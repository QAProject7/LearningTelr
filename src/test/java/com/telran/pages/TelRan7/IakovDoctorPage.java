package com.telran.pages.TelRan7;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by
 */
public class IakovDoctorPage extends Page {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields


    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement ExitLink;

    @FindBy(id = "ctl00_DisplayImportantLinks1_myMenu")
    WebElement DoctorsLeftMenu;

    public IakovDoctorPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }


    //check alert presence
//methods


    public void WaitUntilDoctorPageIsLoaded() {
        waitUntilIsLoadedCustomTime(DoctorsLeftMenu, 10);
    }

    public boolean isOnDoctorPage() {
        return exists(ExitLink);
    }

    public String GettextFromExitLink() {
        return ExitLink.getText();
    }


}