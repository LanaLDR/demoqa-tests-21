package com.demoqa.utils;

import java.util.List;

import static com.demoqa.utils.RandomUtils.*;

public class TestData {
    RandomUtils randomUtils = new RandomUtils();
    public String randomFirstName = randomUtils.getRandomFirstName(),
            randomLastName = randomUtils.getRandomLastName(),
            randomEmail = randomUtils.getRandomEmail(),
            randomGender = randomUtils.getRandomGender(),
            randomPhone = randomUtils.getRandomPhone(),
            randomAddress = randomUtils.getRandomAddress(),
            randomState = randomUtils.getRandomState(),
            randomCity = getRandomCity(randomState),
            randomMonth = randomUtils.getRandomMonth(),
            randomYear = randomUtils.getRandomYear(),
            randomDay = randomUtils.getRandomDay(),
            defaultImage = "image.jpg";

    public List<String> randomSubjects = getRandomSubjects(),
            randomHobbies = getRandomHobbies();
}
