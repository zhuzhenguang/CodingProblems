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
    public List<Talk> talks() {
        return null;
    }

    List<TrackItem> items() {
        return Stream.of(
                new TrackItem(new Time(0), "Lunch"),
                new TrackItem(new Time(5), "Networking Event")
        ).collect(Collectors.toList());
    }
}
