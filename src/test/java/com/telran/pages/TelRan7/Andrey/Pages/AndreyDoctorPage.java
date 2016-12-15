package com.telran.pages.TelRan7.Andrey.Pages;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrey on 02.12.2016.
 */
public class AndreyDoctorPage extends Page {

    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement ExitLink;

    @FindBy(id = "ctl00_DisplayImportantLinks1_myMenu")
    WebElement DoctorsLeftMenu;

    public AndreyDoctorPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SecurityInfrastructure/NotAllowedPage.aspx";
        PageFactory.initElements(driver, this);
    }


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
