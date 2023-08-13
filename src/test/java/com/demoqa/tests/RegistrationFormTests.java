package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.TestData;
import org.junit.jupiter.api.Test;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillingAllFieldsTest() {

        registrationPage.openPage()
                .deletedFooter()
                .setFirstName(testData.randomFirstName)
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
                .selectCity(testData.randomCity)
                .submitRegistration();

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
    }
}
