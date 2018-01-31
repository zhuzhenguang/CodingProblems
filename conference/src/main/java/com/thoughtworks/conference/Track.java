package com.thoughtworks.conference;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Track
 * <p>
 * Created by napoleon on 05/12/2016.
 */
class Track {
    private Talk talk;

    Track(Talk talk) {
        this.talk = talk;
    }

    List<Talk> talks() {
        return Stream.of(
                talk,
                new Talk(new Time(0), "Lunch"),
                new Talk(new Time(5), "Networking Event")
        ).collect(Collectors.toList());
    }
}
