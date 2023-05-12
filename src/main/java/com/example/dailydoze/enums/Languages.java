package com.example.dailydoze.enums;

public enum Languages {
    Russian("Russian"),
    English("English");

    private final String displayValue;

    private Languages(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
