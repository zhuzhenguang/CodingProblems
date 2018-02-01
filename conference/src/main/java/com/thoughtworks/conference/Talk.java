package com.thoughtworks.conference;

/**
 * Talk
 * <p>
 * Created by napoleon on 05/12/2016.
 */
class Talk {
    private static final int START_TIME_EACH_DAY = 21;
    private Duration duration;
    private Time startTime;
    private String topic;

    Talk(Time startTime, String topic) {
        this.startTime = startTime;
        this.topic = topic;
    }

    Talk(Duration duration, String title) {
        this(new Time(START_TIME_EACH_DAY).addMinutes(duration.time()), title);
        this.duration = duration;
    }

    Time startTime() {
        return startTime;
    }

    String topic() {
        return topic;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Duration duration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", startTime.toString(), topic, duration.toString());
    }
}
