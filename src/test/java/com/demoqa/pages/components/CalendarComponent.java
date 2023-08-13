package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement
            reactMonth = $(".react-datepicker__month-select"),
            reactYear = $(".react-datepicker__year-select");

    private String reactDay = ".react-datepicker__day--0";

    public void setDate(String day, String month, String year) {
        reactMonth.selectOption(month);
        reactYear.selectOption(year);
        $(reactDay + day).click();
    }
}
