package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.FormPage;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.qameta.allure.Allure.step;

public class FormTest {
    FormPage formPage = new FormPage();
    TestData testData = new TestData();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("browserName", "chrome");
        //capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1024x768";
        //Configuration.holdBrowserOpen = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    void firstTest() {
        step("Fill form", () -> {
            formPage.openPage()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.email)
                    .setGender(testData.gender)
                    .setUserNumber(testData.mobile)
                    .setBirthDate(testData.day, testData.month, testData.year)
                    .setSubjects(testData.subject)
                    .setHobbies(testData.hobby)
                    .uploadPicture(testData.picture)
                    .setAddress(testData.address)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .submit();
        });
        step("Check form results", () -> {
            formPage.checkResultTableVisible()
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.email)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.mobile)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobby)
                    .checkResult("Picture", testData.picture)
                    .checkResult("Address", testData.address)
                    .checkResult("State and City", testData.state + " " + testData.city);
        });
    }
}
