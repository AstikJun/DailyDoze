package com.example.dailydoze.enums;

public enum Themes {
    Dark("Dark"),
    White("White");

    private final String displayValue;

    private Themes(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
