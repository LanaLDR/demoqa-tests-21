package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.FooterComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    FooterComponent footerComponent = new FooterComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            birthDateInput = $("#dateOfBirth").$(".react-datepicker-wrapper"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicturesField = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit"),
            tableResultTr = $(".table-responsive");

    public RegistrationPage openPage() {
        open("automation-practice-form");
        return this;
    }

    public RegistrationPage deletedFooter() {
        footerComponent.deletedFooter();
        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    public RegistrationPage setUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year){
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(List<String> subjects) {
        for (String subject : subjects){
            subjectInput.setValue(subject).pressEnter();
        }
        return this;
    }
    public RegistrationPage setHobbies(List<String> hobbies) {
        for (String hobby : hobbies){
            hobbiesWrapper.$(byText(hobby)).click();
        }
        return this;
    }
    public RegistrationPage uploadPicture(String fileName) {
        uploadPicturesField.uploadFromClasspath(fileName);
        return this;
    }
    public RegistrationPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }
    public RegistrationPage selectState(String stateName) {
        state.scrollTo().click();
        state.$(byText(stateName)).click();
        return this;
    }
    public RegistrationPage selectCity(String cityName) {
        city.scrollTo().click();
        city.$(byText(cityName)).click();
        return this;
    }
    public RegistrationPage submitRegistration() {
        submitButton.click();
        return this;
    }
    public RegistrationPage checkTableResult(String checkField, String value) {
        tableResultTr.$(byText(checkField)).parent().shouldHave(text(value));
        return this;
    }
}
