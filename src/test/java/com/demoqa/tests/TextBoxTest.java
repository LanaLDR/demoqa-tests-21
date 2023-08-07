package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TextBoxTest extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void registrationTextBoxTest() {
        textBoxPage.openPage()
                .deletedFooter()
                .setFullName("Kirill Ivanov")
                .setEmail("kek@gmail.com")
                .setCurrentAddress("Oktabrskaya 12")
                .setPermanentAddress("Emlutina 12, 172")
                .clickSubmitButton();

        textBoxPage.checkOutputResult(
                "Kirill Ivanov",
                "kek@gmail.com",
                "Oktabrskaya 12",
                "Emlutina 12, 172");
    }
}
