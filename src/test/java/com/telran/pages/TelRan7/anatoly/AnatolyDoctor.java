package com.telran.pages.TelRan7.anatoly;

/**
 * Created by 1 on 24.11.2016.
 */
public class AnatolyDoctor {
    private String PasswordField;
    private String UsernameField;
    private String ConfirmPasswordField;
    private String fNameField;
    private String lNameField;
    private String EmailField;
    private String IdField;
    private String BirthdayDateField;
    private String BirthdayField;
    private String TelephoneField;
    private String StreetField;
    private String HomeField;
    private String CityField;
    private String ClinicField;

    public AnatolyDoctor(String passwordField, String usernameField, String confirmPasswordField,
                         String fNameField, String lNameField, String emailField, String idField,
                         String birthdayDateField, String birthdayField, String telephoneField,
                         String streetField, String homeField, String cityField, String clinicField) {
        PasswordField = passwordField;
        UsernameField = usernameField;
        ConfirmPasswordField = confirmPasswordField;
        this.fNameField = fNameField;
        this.lNameField = lNameField;
        EmailField = emailField;
        IdField = idField;
        BirthdayDateField = birthdayDateField;
        BirthdayField = birthdayField;
        TelephoneField = telephoneField;
        StreetField = streetField;
        HomeField = homeField;
        CityField = cityField;
        ClinicField = clinicField;
    }

    public String getPasswordField() {
        return PasswordField;
    }

    public void setPasswordField(String passwordField) {
        PasswordField = passwordField;
    }

    public String getUsernameField() {
        return UsernameField;
    }

    public void setUsernameField(String usernameField) {
        UsernameField = usernameField;
    }

    public String getConfirmPasswordField() {
        return ConfirmPasswordField;
    }

    public void setConfirmPasswordField(String confirmPasswordField) {
        ConfirmPasswordField = confirmPasswordField;
    }

    public String getfNameField() {
        return fNameField;
    }

    public void setfNameField(String fNameField) {
        this.fNameField = fNameField;
    }

    public String getlNameField() {
        return lNameField;
    }

    public void setlNameField(String lNameField) {
        this.lNameField = lNameField;
    }

    public String getEmailField() {
        return EmailField;
    }

    public void setEmailField(String emailField) {
        EmailField = emailField;
    }

    public String getIdField() {
        return IdField;
    }

    public void setIdField(String idField) {
        IdField = idField;
    }

    public String getBirthdayDateField() {
        return BirthdayDateField;
    }

    public void setBirthdayDateField(String birthdayDateField) {
        BirthdayDateField = birthdayDateField;
    }

    public String getBirthdayField() {
        return BirthdayField;
    }

    public void setBirthdayField(String birthdayField) {
        BirthdayField = birthdayField;
    }

    public String getTelephoneField() {
        return TelephoneField;
    }

    public void setTelephoneField(String telephoneField) {
        TelephoneField = telephoneField;
    }

    public String getStreetField() {
        return StreetField;
    }

    public void setStreetField(String streetField) {
        StreetField = streetField;
    }

    public String getHomeField() {
        return HomeField;
    }

    public void setHomeField(String homeField) {
        HomeField = homeField;
    }

    public String getCityField() {
        return CityField;
    }

    public void setCityField(String cityField) {
        CityField = cityField;
    }

    public String getClinicField() {
        return ClinicField;
    }

    public void setClinicField(String clinicField) {
        ClinicField = clinicField;
    }
}
