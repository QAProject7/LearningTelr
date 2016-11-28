package com.telran.pages.TelRan7.anatoly;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by
 */
public class AnatolyLoginPage extends Page {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;

    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement regButton;

    @FindBy(id = "MainContent_LoginUser_PasswordRequired")
    WebElement passwordRequiredMsg;

    @FindBy(id = "MainContent_LoginUser_UserNameRequired")
    WebElement UserNameRequiredMsg;

    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement RegisterLink;

    //@FindBy(class="forgot" and tagName = "a")
    //WebElement RegisterHyperLink;

    @FindBy(id = "MainContent_LoginUser_CBAgreeToTerms")
    WebElement AgreeToTermsCheckBox;

    @FindBy(id = "MainContent_LoginUser_CustomValidator1")
    WebElement CustomValidator1Msg;

    @FindBy(id = "MainContent_LoginUser_RememberMe")
    WebElement RememberMeCheckBox;

    @FindBy(id = "MainContent_LoginUser_RememberMeLabel")
    WebElement RememberMeLabel;

    @FindBy(id = "transmark")
    WebElement loginNotSuccessfulMsg;

    @FindBy(id = "MainContent_LoginUser_LoginUserValidationSummary")
    WebElement loginValidationMsg;

    public AnatolyLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }


    //check alert presence
    public void FillUserName(String username) {
        setElementText(usernameField, username);
    }

    public void FillPassword(String password) {
        setElementText(passwordField, password);
    }
    public void LoginClick(){
        clickElement(loginButton);
    }
    public void RegClick(){
        clickElement(regButton);
    }
    public void WaitLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(loginButton, 10);
    }
    public Boolean isLoginValidationMsgPresent(){
        return verifyElementIsPresent(loginValidationMsg);
    }
    public void Login(String username, String password) {
        WaitLoginPageIsLoaded();
        FillPassword(username);
        FillUserName(password);
        LoginClick();
    }
}