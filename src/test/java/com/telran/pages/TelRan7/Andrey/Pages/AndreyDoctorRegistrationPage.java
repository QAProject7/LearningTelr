package com.telran.pages.TelRan7.Andrey.Pages;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Andrey on 28.11.2016.
 */

public class AndreyDoctorRegistrationPage extends Page {

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    public WebElement userName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    public WebElement firstName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    public WebElement lastName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    public WebElement email;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    public WebElement password;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    public WebElement personalID;


    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    public WebElement clinicName;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement streetAddress;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement houseNumber;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityName;


    @FindBy(id = "MainContent_AddNewUser")
    WebElement addNewUserButton;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthdayField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement telephone;

    public AndreyDoctorRegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage";

        PageFactory.initElements(driver, this);
    }


    public void FillUsername(String Username) {
        setElementText(userName, Username);
    }

    public void FillFirstName(String FirstName) {
        setElementText(firstName, FirstName);
    }

    public void FillLastName(String LastName) {
        setElementText(lastName, LastName);
    }

    public void FillEmail(String Email) {
        setElementText(email, Email);
    }

    public void FillPassword(String Password) {
        setElementText(password, Password);
    }

    public void FillConfirmPassword(String ConfirmPassword) {
        setElementText(confirmPassword, ConfirmPassword);
    }

    public void FillStreet(String StreetAddress) {
        setElementText(streetAddress, StreetAddress);
    }

    public void FillBirthday(String Birthday) {
        setElementText(birthdayField, Birthday);
    }

    public void FillHouseNumber(String HouseNumber) {
        setElementText(houseNumber, HouseNumber);
    }

    public void FillCity(String City) {
        setElementText(cityName, City);
    }

    public void FillPersonalId(String PersonalID) {
        setElementText(personalID, PersonalID);
    }

    public void FillClinicName(String ClinicName) {
        setElementText(clinicName, ClinicName);
    }

    public void FillTelephone(String Telephone) {
        setElementText(telephone, Telephone);
    }


    public void ClickOnAddNewDoctortButton() {
        clickElement(addNewUserButton);
    }

    public boolean isOnRegistrationPage() {
        return exists(addNewUserButton);
    }

    public void WaitRegPageIsLoaded() {
        waitUntilIsLoadedCustomTime(addNewUserButton, 10);
    }


    public void AddNewDoctor(String userName, String firstName, String lastName, String email, String password,
                             String confirmPassword, String streetAddress, String houseNumber, String birthday,
                             String city, String personalID, String clinicName, String telephone) {

        WaitRegPageIsLoaded();
        FillUsername(userName);
        FillFirstName(firstName);
        FillLastName(lastName);
        FillEmail(email);
        FillPassword(password);
        FillConfirmPassword(confirmPassword);
        FillStreet(streetAddress);
        FillHouseNumber(houseNumber);
        FillCity(city);
        FillBirthday(birthday);
        FillPersonalId(personalID);
        FillClinicName(clinicName);
        FillTelephone(telephone);
        ClickOnAddNewDoctortButton();


    }
}
