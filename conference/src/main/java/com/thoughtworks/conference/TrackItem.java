package com.thoughtworks.conference;

/**
 * TrackItem
 * <p>
 * Created by napoleon on 05/12/2016.
 */
class TrackItem {
    private Time startTime;
    private String topic;

    TrackItem(Time startTime, String topic) {
        this.startTime = startTime;
        this.topic = topic;
    }

    Time startTime() {
        return startTime;
    }

    String topic() {
        return topic;
    }
}
