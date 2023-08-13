package com.demoqa.utils;

import java.util.List;

import static com.demoqa.utils.RandomUtils.*;

public class TestData {
    public String randomFirstName = getRandomFirstName(),
            randomLastName = getRandomLastName(),
            randomEmail = getRandomEmail(),
            randomGender = getRandomGender(),
            randomPhone = getRandomPhone(),
            randomAddress = getRandomAddress(),
            randomState = getRandomState(),
            randomCity = getRandomCity(randomState),
            randomMonth = getRandomMonth(),
            randomYear = getRandomYear(),
            randomDay = getRandomDay(),
            defaultImage = "картиночкааа.jpg";

    public List<String> randomSubjects = getRandomSubjects(),
            randomHobbies = getRandomHobbies();
}
