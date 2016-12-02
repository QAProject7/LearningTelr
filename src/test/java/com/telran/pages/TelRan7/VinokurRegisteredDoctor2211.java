package com.telran.pages.TelRan7;


import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 22.11.2016.
 */
public class VinokurRegisteredDoctor2211 extends Page {
    //fields
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement userName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement firstNameTxt;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lastNameTxt;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement emailField;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement passwordField;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPasswordField;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement PersonalIdTxt;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    WebElement clinicNameTxt;
    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthdayTxt;
    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement contactCellTxt;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement addressTxt;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement houseNumberTxt;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityTxt;

    //buttons
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement buttonDoctorRegistration;
    @FindBy(id = "MainContent_AddNewUser")
    WebElement addNewDoctor;




    //constructor
    public VinokurRegisteredDoctor2211(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }
    //  methods

    public void waitUntilLoginPageIsLoaded() {waitUntilIsLoadedCustomTime(buttonDoctorRegistration,10);}

    public void waitUntilDoctorRegButtonIsLoaded() {waitUntilIsLoadedCustomTime(addNewDoctor,10);}

    public void clickDoctorRegistrationLink () {clickElement(buttonDoctorRegistration);}

    public void fillUserName(String username) { setElementText(userName, username);}

    public void fillFirstName(String firstName) {
        setElementText(firstNameTxt, firstName);
    }

    public void fillLastName(String lastName) {setElementText(lastNameTxt, lastName);}

    public void fillEmail(String email) {setElementText(emailField, email);}

    public void fillPassword(String password) {setElementText(passwordField, password);}

    public void fillConfirmPassword(String confirmPassword) {setElementText(confirmPasswordField, confirmPassword);}

    public void fillPersonalId(String personalId) {setElementText(PersonalIdTxt, personalId);}

    public void fillClinic(String clinicName) {
        setElementText(clinicNameTxt, clinicName);
    }

    public void fillBirthday(String birthday) { setElementText  (birthdayTxt, birthday);}

    public void fillContactCell(String contactCell) {setElementText(contactCellTxt, contactCell);}

    public void fillAddress(String address) {
        setElementText(addressTxt, address);
    }

    public void fillHouseNumber(String houseNumber) {
        setElementText(houseNumberTxt, houseNumber);
    }

    public void fillCity(String city) {
        setElementText(cityTxt, city);
    }

    public void clickAddNewDoctor() {
        clickElement(addNewDoctor);
    }

    public void registrationDoctorFillForm
            (String username, String firstName, String lastName, String email, String password,
            String confirmPassword,String personalId,String clinicName, String birthday,
             String contactCell,String address, String houseNumber, String city){
        waitUntilLoginPageIsLoaded();
        clickDoctorRegistrationLink ();
        waitUntilDoctorRegButtonIsLoaded();
        fillUserName(username);
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
        fillPersonalId(personalId);
        fillClinic(clinicName);
        fillBirthday(birthday);
        fillContactCell(contactCell);
        fillAddress(address);
        fillHouseNumber(houseNumber);
        fillCity(city);
        clickAddNewDoctor();
    }


}
