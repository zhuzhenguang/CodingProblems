package com.thoughtworks.conference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Track
 * <p>
 * Created by napoleon on 05/12/2016.
 */
class Track {
    private List<Talk> talks;

    Track() {
        talks = new ArrayList<>();
    }

    List<Talk> talks() {
        return Stream.concat(talks.stream(), Stream.of(
                new Talk(new Time(0), "Lunch"),
                new Talk(new Time(5), "Networking Event")
        )).collect(Collectors.toList());
    }

    public void addTalk(Talk talk) {
        talk.setStartTime(nextAvailableTime());
        talks.add(talk);
    }

    private Time nextAvailableTime() {
        if (talks.isEmpty()) {
            return new Time(21);
        } else {
            return talks.get(0).startTime().addMinutes(talks.get(0).duration().time());
        }
    }
}
