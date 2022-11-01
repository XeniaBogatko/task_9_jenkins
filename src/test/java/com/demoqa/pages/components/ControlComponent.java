package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ControlComponent {

    public ControlComponent setValue(String name) {
        $("#stateCity-wrapper").$(byText(name)).click();
        return this;
    }
}

