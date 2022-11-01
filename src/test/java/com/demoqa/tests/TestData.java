package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    static Faker faker = new Faker(new Locale("sk"));
    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            address = faker.address().streetAddress(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            gender = "Other",
            subject = "English",
            hobby = "Music",
            picture = "1660769245797.jpeg",
            state = "Haryana",
            city = "Karnal",
            day = "30",
            month = "July",
            year = "2008";
}
