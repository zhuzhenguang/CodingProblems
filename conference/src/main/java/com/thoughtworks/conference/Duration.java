package com.thoughtworks.conference;

class Duration {
    private final int time;
    private String durationString;

    Duration(String durationString) {
        this.durationString = durationString;
        time = durationString.contains("min")
                ? Integer.parseInt(durationString.substring(0, durationString.indexOf("min")))
                : -1;
    }

    @Override
    public String toString() {
        return durationString;
    }

    public int time() {
        return time;
    }
}
