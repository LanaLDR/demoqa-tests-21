package com.demoqa.utils;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Collections.shuffle;

public class RandomUtils {
    private Faker fakerEng = new Faker(new Locale("en"));
    private static String[] genders = {"Male", "Female", "Other"};
    private static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private static List<String> subjects = Arrays.asList("Maths", "English", "Physics", "Chemistry", "Computer Science");
    private static List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
    private static String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public String getRandomFirstName() {
        return fakerEng.name().firstName();
    }

    public String getRandomLastName() {
        return fakerEng.name().lastName();
    }

    public String getRandomEmail() {
        return fakerEng.internet().emailAddress();
    }

    public String getRandomGender() {
        return fakerEng.options().option(genders);
    }

    public String getRandomPhone() {
        return fakerEng.numerify("##########");
    }

    public static List<String> getRandomSubjects() {
        int rndNum = getRandomInt(0, subjects.size());
        shuffle(subjects);
        return subjects.subList(0, rndNum);
    }

    public static List<String> getRandomHobbies() {
        int rndNum = getRandomInt(0, hobbies.size());
        shuffle(hobbies);
        return hobbies.subList(0, rndNum);
    }

    public String getRandomAddress() {
        return fakerEng.address().fullAddress();
    }

    public String getRandomState() {
        return fakerEng.options().option(state);
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                String[] city = {"Delhi", "Gurgaon", "Noida"};
                return new Faker().options().option(city);
            }
            case "Uttar Pradesh": {
                String[] city = {"Agra", "Lucknow", "Merrut"};
                return new Faker().options().option(city);
            }
            case "Haryana": {
                String[] city = {"Karnal", "Panipat"};
                return new Faker().options().option(city);
            }
            case "Rajasthan": {
                String[] city = {"Jaipur", "Jaiselmer"};
                return new Faker().options().option(city);
            }
            default:
                return null;
        }
    }

    public String getRandomMonth() {
        return fakerEng.options().option(months);
    }

    public String getRandomYear() {
        return fakerEng.random().nextInt(1900, 2023).toString();
    }

    public String getRandomDay() {
        String day = fakerEng.random().nextInt(1, 28).toString();
        return Integer.parseInt(day) > 10 ? day : "0" + day;
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
