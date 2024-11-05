package com.INQC.Entity.enums;

public enum YesNo {
    YES('Y'),
    NO('N');

    private final char value;

    YesNo(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static YesNo fromChar(char value) {
        switch (value) {
            case 'Y':
                return YES;
            case 'N':
                return NO;
            default:
                throw new IllegalArgumentException("Invalid value: " + value);
        }
    }
}
