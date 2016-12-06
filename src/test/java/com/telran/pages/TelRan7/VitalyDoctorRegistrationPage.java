package com.telran.pages.TelRan7;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vitaliy on 23.11.2016.
 */
public class VitalyDoctorRegistrationPage extends Page {

    //Fields
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement GoToDoctorRegistration;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement UserName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement FirstName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement LastName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement Email;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement Passord;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement RepeatThePassword;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement PersonalId;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement Street;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement HouseNumber;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement City;
    @FindBy(id = "MainContent_AddNewUser")
    WebElement SaveNewDoctorButton;
    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement ExitLink;

    @FindBy(id = "ctl00_DisplayImportantLinks1_myMenu")
    WebElement DoctorsRightMenu;


    //Methods
    public VitalyDoctorRegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    public void goToDoctorRegistration() {
        clickElement(GoToDoctorRegistration);
    }

    public void waitUntilIsLoadedCusTime() {
        waitUntilIsLoadedCustomTime(UserName, 10);
    }

    public void fillUserNameField(String userName) {
        setElementText(UserName, userName);
    }

    public void fillFirstNameField(String firstName) {
        setElementText(FirstName, firstName);
    }

    public void fillLastNameField(String lastName) {
        setElementText(LastName, lastName);
    }

    public void fillEmailField(String email) {
        setElementText(Email, email);
    }

    public void fillPasswordFields(String password) {
        setElementText(Passord, password);
        setElementText(RepeatThePassword, password);
    }

    public void fillPersonalIdField(String id) {
        setElementText(PersonalId, id);

    }

    public void fillAdressFields(String city, String street, String houseNumber) {
        setElementText(City, city);
        setElementText(Street, street);
        setElementText(HouseNumber, houseNumber);
    }

    public void clickOnSaveNewDoctorButton() {
        clickElement(SaveNewDoctorButton);
    }

    public void DoctorRegisttation(String username, String firstname, String lastname, String email, String password, String id,
                                   String city, String street, String housenumber) {
        goToDoctorRegistration();
        waitUntilIsLoadedCusTime();
        fillUserNameField(username);
        fillFirstNameField(firstname);
        fillLastNameField(lastname);
        fillEmailField(email);
        fillPasswordFields(password);
        fillPersonalIdField(id);
        fillAdressFields(city, street, housenumber);
        clickOnSaveNewDoctorButton();
    }

    public void waitUntilDoctorsPageIsLoaded() {
        waitUntilIsLoadedCustomTime(DoctorsRightMenu, 10);
    }

    public boolean isOnDoctorPage() {
        return exists(ExitLink);
    }

    public String getTextFromExitLink() {
        return ExitLink.getText();
    }
}
