package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Collections.shuffle;

public class RandomUtils {
    static Faker fakerEng = new Faker(new Locale("en"));
    static String[] genders = {"Male", "Female", "Other"};
    static String[] months =  {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    static List<String> subjects = Arrays.asList("Maths", "English", "Physics", "Chemistry", "Computer Science");
    static List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
    static String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    public static void main(String[] args) {
        System.out.println(getRandomFirstName());
        System.out.println(getRandomLastName());
        System.out.println(getRandomEmail());
        System.out.println(getRandomPhone());
        System.out.println(getRandomDate());
        System.out.println(getRandomSubjects());
    }

    public static String getRandomFirstName() {
        return fakerEng.name().firstName();
    }

    public static String getRandomLastName() {
        return fakerEng.name().lastName();
    }

    public static String getRandomEmail() {
        return fakerEng.internet().emailAddress();
    }

    public static String getRandomGender() {
        return fakerEng.options().option(genders);
    }

    public static String getRandomPhone() {
        return fakerEng.numerify("##########");
    }

    public static Date getRandomDate() {
        return fakerEng.date().birthday();
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

    public static String getRandomAddress() {
        return fakerEng.address().fullAddress();
    }

    public static String getRandomState() {
        return fakerEng.options().option(state);
    }

    public static String getRandomCity(String state) {
        switch(state) {
            case "NCR": {
                String[] city =  {"Delhi", "Gurgaon", "Noida"};
                return new Faker().options().option(city);
            }
            case "Uttar Pradesh": {
                String[] city =  {"Agra", "Lucknow", "Merrut"};
                return new Faker().options().option(city);
            }
            case "Haryana": {
                String[] city =  {"Karnal", "Panipat"};
                return new Faker().options().option(city);
            }
            case "Rajasthan": {
                String[] city =  {"Jaipur", "Jaiselmer"};
                return new Faker().options().option(city);
            }
            default:
                return null;
        }
    }

    public static String getRandomMonth() {
        return fakerEng.options().option(months);
    }

    public static String getRandomYear() {
        return fakerEng.random().nextInt(1900, 2023).toString();
    }

    public static String getRandomDay() {
        String day = fakerEng.random().nextInt(1, 28).toString();
        return Integer.parseInt(day) > 10 ? day : "0" + day;
    }

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
