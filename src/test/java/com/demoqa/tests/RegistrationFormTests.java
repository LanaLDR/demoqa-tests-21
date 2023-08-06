package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class RegistrationFormTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillingAllFieldsTest() {
        registrationPage.openPage()
                .deletedFooter()
                .setFirstName("Kirill")
                .setLastName("Ivanov")
                .setUserEmail("kirill.ivanov@gmail.com")
                .setGender("Male")
                .setUserNumber("8980362893")
                .setBirthDate("20", "January", "1999")
                .setSubjects(List.of("Math", "English"))
                .setHobbies(List.of("Sports", "Music"))
                .uploadPicture("картиночкааа.jpg")
                .setCurrentAddress("Emlutina 12, 165")
                .selectState("NCR")
                .selectCity("Gurgaon")
                .submitRegistration();

        registrationPage.checkTableResult("Student Name", "Kirill Ivanov")
                        .checkTableResult("Student Email", "kirill.ivanov@gmail.com")
                        .checkTableResult("Gender", "Male")
                        .checkTableResult("Mobile", "8980362893")
                        .checkTableResult("Date of Birth", "20 January,1999")
                        .checkTableResult("Subjects", "Maths, English")
                        .checkTableResult("Hobbies", "Sports, Music")
                        .checkTableResult("Picture", "картиночкааа.jpg")
                        .checkTableResult("Address", "Emlutina 12, 165")
                        .checkTableResult("State and City", "NCR Gurgaon");
    }
}
