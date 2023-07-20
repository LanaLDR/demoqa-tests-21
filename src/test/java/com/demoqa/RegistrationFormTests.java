package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    @BeforeEach
    void beforeEach() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @Test
    void fillingAllFieldsTest() {
        $("#firstName").setValue("Kirill");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("kirill.ivanov@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("8980362893");
        $("#dateOfBirth").$(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--020").click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/картиночкааа.jpg"));
        $("#currentAddress").setValue("Emlutina 12, 165");

        $("#state").scrollTo();
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        $("#submit").click();

        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Kirill Ivanov"));
        $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("kirill.ivanov@gmail.com"));
        $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("8980362893"));
        $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("20 January,1999"));
        $("tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Maths"));
        $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Music"));
        $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("картиночкааа.jpg"));
        $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Emlutina 12, 165"));
        $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Gurgaon"));
    }
}
