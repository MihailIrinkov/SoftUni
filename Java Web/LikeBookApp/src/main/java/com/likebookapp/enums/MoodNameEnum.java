package com.likebookapp.enums;

public enum MoodNameEnum {
//    HAPPY, SAD, INSPIRED


    HAPPY ("Happy"),
    SAD ("Sad"),
    INSPIRED ("Inspired");

    private final String value;

    private MoodNameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
