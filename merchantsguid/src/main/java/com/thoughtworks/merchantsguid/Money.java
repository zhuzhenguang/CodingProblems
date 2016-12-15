package com.thoughtworks.merchantsguid;

/**
 * Money
 * <p>
 * Created by napoleon on 11/12/2016.
 */
class Money {
    private String unit;
    private String[] numbers;

    Money(String unit, String... numbers) {
        this.unit = unit;
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return String.join(" ", numbers) + " " + unit;
    }
}
