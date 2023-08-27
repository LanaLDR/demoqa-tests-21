package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @Tag("remote")
    @DisplayName("Регистрация со всеми полями")
    void fillingAllFieldsTest() {

        step("Открываем страницу регистрации", () -> {
            registrationPage.openPage()
                    .deletedFooter();
        });

        step("Заполняем поля регистрации", () -> {
            registrationPage.setFirstName(testData.randomFirstName)
                    .setLastName(testData.randomLastName)
                    .setUserEmail(testData.randomEmail)
                    .setGender(testData.randomGender)
                    .setUserNumber(testData.randomPhone)
                    .setBirthDate(testData.randomDay, testData.randomMonth, testData.randomYear)
                    .setSubjects(testData.randomSubjects)
                    .setHobbies(testData.randomHobbies)
                    .uploadPicture(testData.defaultImage)
                    .setCurrentAddress(testData.randomAddress)
                    .selectState(testData.randomState)
                    .selectCity(testData.randomCity);
        });

        step("Кликаем submit", () -> {
            registrationPage.submitRegistration();

        });

        step("Проверяем сохранение введеных данных", () -> {
            registrationPage.checkTableResult("Student Name", testData.randomFirstName + " " + testData.randomLastName)
                    .checkTableResult("Student Email", testData.randomEmail)
                    .checkTableResult("Gender", testData.randomGender)
                    .checkTableResult("Mobile", testData.randomPhone)
                    .checkTableResult("Date of Birth", testData.randomDay + " " + testData.randomMonth + "," + testData.randomYear)
                    .checkTableResult("Subjects", String.join(", ", testData.randomSubjects))
                    .checkTableResult("Hobbies", String.join(", ", testData.randomHobbies))
                    .checkTableResult("Picture", testData.defaultImage)
                    .checkTableResult("Address", testData.randomAddress)
                    .checkTableResult("State and City", testData.randomState + " " + testData.randomCity);
        });
    }
}
