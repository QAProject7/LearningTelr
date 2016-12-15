package com.telran.pages.TelRan7.anatoly;

 import com.telran.pages.Page;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;
 import java.util.Random;

 /**
 * Created by
 */
public class AnatolyRegPage extends Page {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static final int MAX_LENGTH_NAME = 10;
    static Random gen = new Random();

    //fields
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement fNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement emailField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement idField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthdayDateField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")
    WebElement birthdayField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement telephoneField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement streetField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement homeField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    WebElement clinicField;

    @FindBy(id = "MainContent_AddNewUser")
    WebElement addDoctorButton;

    public AnatolyRegPage(WebDriver driver) {
        super(driver);
        baseUrl = "http://dhclinicappv2stg.item-soft.co.il";
        this.PAGE_URL = baseUrl + "/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }


    //check alert presence
    public void FillUserName(String login) {
        setElementText(usernameField, login);
    }

    public void FillPassword(String password) {
        setElementText(passwordField, password);
    }

    public void FillConfirmPassword(String password) {
        setElementText(confirmPasswordField, password);
    }

    public void FillFname(String name) {
        setElementText(fNameField, name);
    }

    public void FillLname(String name) {
        setElementText(lNameField, name);
    }

    public void FilleMail(String name) {
        setElementText(emailField, name);
    }

    public void FillId(String name) {
        setElementText(idField, name);
    }

    public void FillBirthdayDate(String name) {
        setElementText(birthdayDateField, name);
    }

    public void FillBirthday(String name) {
        setElementText(birthdayField, name);
    }

    public void FillTelephone(String name) {setElementText(telephoneField, name);
    }

    public void FillStreet(String name) {
        setElementText(streetField, name);
    }

    public void FillHome(String name) {  setElementText(homeField, name);
    }

    public void FillCity(String name) {
        setElementText(cityField, name);
    }

    public void FillClinic(String name) {
        setElementText(clinicField, name);
    }

    public void AddDoctorClick() {
        clickElement(addDoctorButton);
    }

    public void WaitRegPageIsLoaded() {
        waitUntilIsLoadedCustomTime(addDoctorButton, 10);
    }

    public boolean isOnRegistrationPage() {
        return exists(addDoctorButton);
    }

    public String generateZeut() {
        String number = createId();
        //Log.info("Doctor's Zeut generated is <" + number + ">");
        return number;
    }
    public static String getRandomName(){
        int lengthName = 3 + gen.nextInt(MAX_LENGTH_NAME);
        char c;
        String name = "";
        c = (char) (65 + gen.nextInt(26));
        name += c ;
        for(int i = 1; i < lengthName; i++)
            name += (char)(97 + gen.nextInt(26));
        return name;
    }
    public static String getRandomUser(){
        return "userTol" + gen.nextInt(3);
    }
    public void AddDoctor(AnatolyDoctor newDoctor) {
        WaitRegPageIsLoaded();
        FillPassword(newDoctor.getPasswordField());
        FillUserName(newDoctor.getUsernameField());
        FillConfirmPassword(newDoctor.getConfirmPasswordField());
        FillFname(newDoctor.getfNameField());
        FillLname(newDoctor.getlNameField());
        FilleMail(newDoctor.getEmailField());
        FillId(newDoctor.getIdField());
        FillBirthdayDate(newDoctor.getBirthdayDateField());
        FillBirthday(newDoctor.getBirthdayField());
        FillTelephone(newDoctor.getTelephoneField());
        FillStreet(newDoctor.getStreetField());
        FillHome(newDoctor.getHomeField());
        FillCity(newDoctor.getCityField());
        FillClinic(newDoctor.getClinicField());

        AddDoctorClick();
    }
    public void AddDoctor(String newDoctor[]) {
        WaitRegPageIsLoaded();
        FillPassword(newDoctor[0]);
        FillUserName(newDoctor[1]);
        FillConfirmPassword(newDoctor[2]);
        FillFname(newDoctor[3]);
        FillLname(newDoctor[4]);
        FilleMail(newDoctor[5]);
        FillId(newDoctor[6]);
        FillBirthdayDate(newDoctor[7]);
        FillBirthday(newDoctor[8]);
        FillTelephone(newDoctor[9]);
        FillStreet(newDoctor[10]);
        FillHome(newDoctor[11]);
        FillCity(newDoctor[12]);
        FillClinic(newDoctor[13]);

        AddDoctorClick();
    }
}