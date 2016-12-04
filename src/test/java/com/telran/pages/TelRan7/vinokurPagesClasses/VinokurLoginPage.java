package com.telran.pages.TelRan7.vinokurPagesClasses;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Vinokur on 24.11.2016.
 */
public class VinokurLoginPage extends Page {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement LoginButton;

    @FindBy(id = "Top1_HeadLoginView_DisplayName")
    WebElement DoctorLink;

    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement ExitLink;

    public VinokurLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }



//methods
    public void FillUsername(String username) {
        setElementText(usernameField, username);
    }

    public void FillPassword(String password) {
        setElementText(passwordField, password);
    }

    public void ClickOnLogin() {
        clickElement(LoginButton);
    }

    public void WaitUntilLoginPageIsLoaded() { waitUntilIsLoadedCustomTime(LoginButton, 10);}

    public void WaitUntilDoctorPageIsLoaded (){ waitUntilIsLoadedCustomTime(DoctorLink, 10);}

    public void Login(String username, String password) {
        WaitUntilLoginPageIsLoaded();
        FillUsername(username);
        FillPassword(password);
        ClickOnLogin();
    }

    public boolean IsOnDoctorPage() {
        return exists(DoctorLink);}

    public String GetTextFromExitPage(){
        return ExitLink.getText();
    }
}