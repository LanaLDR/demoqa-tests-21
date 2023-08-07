package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FooterComponent {
    public void deletedFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
