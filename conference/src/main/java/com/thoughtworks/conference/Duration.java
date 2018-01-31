package com.thoughtworks.conference;

class Duration {
    private String durationString;

    Duration(String durationString) {
        this.durationString = durationString;
    }

    @Override
    public String toString() {
        return durationString;
    }
}
