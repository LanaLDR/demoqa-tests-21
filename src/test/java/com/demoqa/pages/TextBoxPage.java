package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.FooterComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    FooterComponent footerComponent = new FooterComponent();
    SelenideElement
            userFullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputResult = $("#output");

    public TextBoxPage openPage() {
        open("text-box");
        return this;
    }

    public TextBoxPage deletedFooter() {
        footerComponent.deletedFooter();
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        userFullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkNameResult(String name) {
        outputResult.$("#name").shouldHave(text("Name:" + name));
        return this;
    }

    public TextBoxPage checkEmailResult(String email) {
        outputResult.$("#email").shouldHave(text("Email:" + email));
        return this;
    }

    public TextBoxPage checkCurrentAddressResult(String address) {
        outputResult.$("#currentAddress").shouldHave(text("Current Address :" + address));
        return this;
    }

    public TextBoxPage checkPermanentAddressResult(String address) {
        outputResult.$("#permanentAddress").shouldHave(text("Permananet Address :" + address));
        return this;
    }

    public TextBoxPage checkOutputResult(String name, String email, String currentAddress, String permanentAddress) {
        checkNameResult(name);
        checkEmailResult(email);
        checkCurrentAddressResult(currentAddress);
        checkPermanentAddressResult(permanentAddress);
        return this;
    }
}
