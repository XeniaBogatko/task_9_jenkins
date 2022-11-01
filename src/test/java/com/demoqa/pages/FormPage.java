package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ControlComponent;
import com.demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    //Elements
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultTableComponent resultTableComponent = new ResultTableComponent();
    private final ControlComponent controlComponent = new ControlComponent();
    private final SelenideElement
            firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");

    //Actions
    public FormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#ad_unit').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        return this;
    }

    public FormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public FormPage clearFirstName(String value) {
        firstNameInput.clear();
        return this;
    }

    public FormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public FormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public FormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public FormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public FormPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public FormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public FormPage uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public FormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public FormPage setState(String name) {
        $("#state").click();
        controlComponent.setValue(name);
        return this;
    }

    public FormPage setCity(String name) {
        $("#city").click();
        controlComponent.setValue(name);
        return this;
    }

    public FormPage submit() {
        $("#submit").click();
        return this;
    }

    public FormPage checkResultTableVisible() {
        resultTableComponent.checkVisible();
        return this;
    }

    public FormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);
        return this;
    }
}
