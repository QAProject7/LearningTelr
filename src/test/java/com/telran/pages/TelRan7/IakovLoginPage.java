package com.telran.pages.TelRan7;

import com.telran.LogLog4j;
import com.telran.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by
 */
public class IakovLoginPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement LoginButton;

    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement ExitLink;

    @FindBy(id = "ctl00_DisplayImportantLinks1_myMenu")
    WebElement DoctorsLeftMenu;

    public IakovLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }


    //check alert presence
//methods
    public void FillUsername(String username) {
        setElementText(usernameField, username);
        Log.info("Filling username field with " + username);
    }

    public void FillPassword(String password) {
        setElementText(passwordField, password);
        Log.info("Filling password field with password " + password);
    }

    public void ClickOnLogin() {
        clickElement(LoginButton);
        Log.info("Click to Login");
    }

    public void WaitUntilLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(LoginButton, 10);
        Log.info("Waiting until Login page is loaded");
    }

    public void Login(String username, String password) {
        WaitUntilLoginPageIsLoaded();
        FillUsername(username);
        FillPassword(password);
        ClickOnLogin();
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