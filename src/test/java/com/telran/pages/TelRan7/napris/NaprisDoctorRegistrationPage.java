

import com.telran.LogLog4j;
import com.telran.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Napris on 24.11.2016.
 */
public class NaprisDoctorRegistrationPage extends Page {
    private static Logger log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement userNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement firstNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lastNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement emailField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement personalIdField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    WebElement clinicNameField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthdayField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement contactCellField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement streetField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement houseNumberField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityField;

    //buttons
    @FindBy(id = "MainContent_AddNewUser")
    WebElement addNewUserButton;

    //links
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement doctorRegistrationLink;

    //constructor
    public NaprisDoctorRegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    //methods
    public void waitUntilLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(doctorRegistrationLink, 10);
        log.info("Waiting 10sec until Login Page is loaded");
    }

    public void clickOnDoctorRegistrationLink() {
        clickElement(doctorRegistrationLink);
        log.info("click on Doctor Registration link");
    }

    public void waitUntilDoctorRegistrationPageIsLoaded() {
        waitUntilIsLoadedCustomTime(addNewUserButton, 10);
        log.info("Waiting 10sec until Doctor Registration Page is loaded");
    }

    public void fillUserName(String userName) {
        setElementText(userNameField, userName);
        log.info("Filling username field: " + userName);
    }

    public void fillFirstName(String firstName) {
        setElementText(firstNameField, firstName);
        log.info("Filling firstName field: " + firstName);
    }

    public void fillLastName(String lastName) {
        setElementText(lastNameField, lastName);
        log.info("Filling lastName field: " + lastName);
    }

    public void fillEmail(String email) {
        setElementText(emailField, email);
        log.info("Filling email field: " + email);
    }

    public void fillPassword(String password) {
        setElementText(passwordField, password);
        log.info("Filling password field: " + password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        setElementText(confirmPasswordField, confirmPassword);
        log.info("Filling confirmPassword field: " + confirmPassword);
    }

    public void fillPersonalId(String personalId) {
        setElementText(personalIdField, personalId);
        log.info("Filling personalId field: " + personalId);
    }

    public void fillClinicName(String clinicName) {
        setElementText(clinicNameField, clinicName);
        log.info("Filling clinicName field: " + clinicName);
    }

    public void fillBirthday(String birthday) {
        setElementText(birthdayField, birthday);
        log.info("Filling birthday field: " + birthday);
    }

    public void fillContactCell(String contactCell) {
        setElementText(contactCellField, contactCell);
        log.info("Filling contactCell field: " + contactCell);
    }

    public void fillStreet(String street) {
        setElementText(streetField, street);
        log.info("Filling street field: " + street);
    }

    public void fillHouseNumber(String houseNumber) {
        setElementText(houseNumberField, houseNumber);
        log.info("Filling houseNumber field: " + houseNumber);
    }

    public void fillCity(String city) {
        setElementText(cityField, city);
        log.info("Filling city field: " + city);
    }

    public void clickOnAddNewDoctor() {
        clickElement(addNewUserButton);
        log.info("Click on 'addNewUser' button");
    }

    public void doctorRegistration(String userName, String firstName, String lastName,
                                   String email, String password, String confirmPassword,
                                   String personalId, String clinicName, String birthday,
                                   String contactCell, String street, String houseNumber, String city) {
        waitUntilLoginPageIsLoaded();
        clickOnDoctorRegistrationLink();
        waitUntilDoctorRegistrationPageIsLoaded();
        fillUserName(userName);
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
        fillPersonalId(personalId);
        fillClinicName(clinicName);
        fillBirthday(birthday);
        fillContactCell(contactCell);
        fillStreet(street);
        fillHouseNumber(houseNumber);
        fillCity(city);
        clickOnAddNewDoctor();
    }
}
