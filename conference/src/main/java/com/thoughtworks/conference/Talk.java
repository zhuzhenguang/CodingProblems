package com.thoughtworks.conference;

/**
 * Talk
 * <p>
 * Created by napoleon on 05/12/2016.
 */
class Talk {
    private Time startTime;
    private String topic;

    Talk(Time startTime, String topic) {
        this.startTime = startTime;
        this.topic = topic;
    }

    Talk(Duration duration, String title) {
        this(new Time(21), title);
    }

    Time startTime() {
        return startTime;
    }

    String topic() {
        return topic;
    }
}
