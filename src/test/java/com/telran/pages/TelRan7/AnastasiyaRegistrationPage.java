package com.telran.pages.TelRan7;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Copm on 24/11/2016.
 */
public class AnastasiyaRegistrationPage extends Page {

    //fields
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement GoToThePatientPageButton;


    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement usernamePatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement FirstNamePatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement LastNamePatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement MailPatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement passwordPatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPasswordPatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement StreetAddressPatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement NumberHouseAddressPatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement CityAddressPatientField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement PersonalIdPatientField;

    @FindBy(id = "MainContent_AddNewUser")
    WebElement AddNewPatientPageButton;

    public AnastasiyaRegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    //Go to The pacient page from Login page
    public void ClickOnGoToPacientPageButton(){
        clickElement(GoToThePatientPageButton);
    }

    public void FillUsernamePatient(String userName){
        setElementText(usernamePatientField, userName);
    }

    public void FillFirstNamePatient(){ setElementText(FirstNamePatientField, "FirstName"); }

    public void FillLastNamePatient(){
        setElementText(LastNamePatientField, "LastName");
    }

    public void FillMailPatient(){
        setElementText(MailPatientField, "Mail@yopmail.com");
    }

    public void FillPasswordPatient(){
        setElementText(passwordPatientField, "Password");
    }

    public void FillConfirmPasswordPatient(){
        setElementText(confirmPasswordPatientField, "Password");
    }

    public void FillStreetPatient(){
        setElementText(StreetAddressPatientField, "Street");
    }

    public void FillNumberHousePatient(){
        setElementText(NumberHouseAddressPatientField, "10");
    }

    public void FillCityPatient(){
        setElementText(CityAddressPatientField, "City");
    }

    public void FillPersonalIdPatient(){
        setElementText(PersonalIdPatientField, "337848451");
    }

    public void ClickOnAddNewPacientButton(){
        clickElement(AddNewPatientPageButton);
    }


    public void AddNewPatient(){
        FillUsernamePatient("UserName");
        FillFirstNamePatient();
        FillLastNamePatient();
        FillMailPatient();
        FillPasswordPatient();
        FillConfirmPasswordPatient();
        FillStreetPatient();
        FillNumberHousePatient();
        FillCityPatient();
        FillPersonalIdPatient();
        ClickOnAddNewPacientButton();
    }



}
