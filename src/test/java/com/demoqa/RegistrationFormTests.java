package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @BeforeEach
    void beforeEach() {
        open("automation-practice-form");
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
        $("#uploadPicture").uploadFromClasspath("картиночкааа.jpg");
        $("#currentAddress").setValue("Emlutina 12, 165");

        $("#state").scrollTo();
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Gurgaon")).click();

        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Kirill Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("kirill.ivanov@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8980362893"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("20 January,1999"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("картиночкааа.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Emlutina 12, 165"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));
    }
}
