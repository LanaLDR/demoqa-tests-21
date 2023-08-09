package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.TestData.*;

public class RegistrationFormTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillingAllFieldsTest() {

        registrationPage.openPage()
                .deletedFooter()
                .setFirstName(randomFirstName)
                .setLastName(randomLastName)
                .setUserEmail(randomEmail)
                .setGender(randomGender)
                .setUserNumber(randomPhone)
                .setBirthDate(randomDay, randomMonth, randomYear)
                .setSubjects(randomSubjects)
                .setHobbies(randomHobbies)
                .uploadPicture(defaultImage)
                .setCurrentAddress(randomAddress)
                .selectState(randomState)
                .selectCity(randomCity)
                .submitRegistration();

        registrationPage.checkTableResult("Student Name", randomFirstName+" "+ randomLastName)
                        .checkTableResult("Student Email", randomEmail)
                        .checkTableResult("Gender", randomGender)
                        .checkTableResult("Mobile", randomPhone)
                        .checkTableResult("Date of Birth", randomDay + " " + randomMonth + "," + randomYear)
                        .checkTableResult("Subjects", String.join(", ", randomSubjects))
                        .checkTableResult("Hobbies", String.join(", ", randomHobbies))
                        .checkTableResult("Picture", defaultImage)
                        .checkTableResult("Address", randomAddress)
                        .checkTableResult("State and City", randomState + " " + randomCity);
    }
}
