package com.thoughtworks.conference;

public class InputParser {
    private final String durationString;
    private final String topic;

    InputParser(String input) {
        String[] inputArray = input.split(" ");
        durationString = inputArray[inputArray.length - 1];
        topic = input.substring(0, input.lastIndexOf(" "));
    }

    public String durationString() {
        return durationString;
    }

    public String title() {
        return topic;
    }
}
