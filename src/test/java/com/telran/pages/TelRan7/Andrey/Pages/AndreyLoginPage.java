package com.telran.pages.TelRan7.Andrey.Pages;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Andrey on 28.11.2016.
 */


public class AndreyLoginPage extends Page {


    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement LoginButton;

    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegistrarionPageButton;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),'שם משתמש חובה')]")
    private WebElement wrongUsernameAlert;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),'סיסמא חובה.')]")
    private WebElement wrongPasswordAlert;

    public AndreyLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    public void FillUsername(String username) {
        setElementText(usernameField, username);
    }

    public void FillPassword(String password) {
        setElementText(passwordField, password);
    }

    public void ClickOnLogin() {
        clickElement(LoginButton);
    }

    public void WaitUntilLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(LoginButton, 10);
    }


    public void ClickOnGoToRegistrPageButton() {
        clickElement(goToRegistrarionPageButton);
    }


    public boolean alertMessageNotValidUsername() {
        return exists(wrongUsernameAlert);
    }

    public boolean alertMessageNotValidPassword() {
        return exists(wrongPasswordAlert);
    }

    public void Login(String username, String password) {
        WaitUntilLoginPageIsLoaded();
        FillUsername(username);
        FillPassword(password);
        ClickOnLogin();
        WaitUntilLoginPageIsLoaded();
    }


}
