package com.telran.pages.TelRan7.napris;

import com.telran.LogLog4j;
import com.telran.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Napris on 23.11.2016.
 */
public class NaprisLoginPage extends Page {
    private static Logger log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    //buttons
    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;

    //constructor
    public NaprisLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    //methods
    public void fillUserName(String username) {
        setElementText(usernameField, username);
        log.info("Filling username field: " + username);
    }

    public void fillPassword(String password) {
        setElementText(passwordField, password);
        log.info("Filling password field: " + password);
    }

    public void clickOnLogin() {
        clickElement(loginButton);
        log.info("Click on 'Login' button");
    }

    public void waitUntilLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(loginButton, 10);
        log.info("Waiting 10sec until Login Page is loaded");
    }

    public void login(String username, String password) {
        waitUntilLoginPageIsLoaded();
        fillUserName(username);
        fillPassword(password);
        clickOnLogin();
    }
}
