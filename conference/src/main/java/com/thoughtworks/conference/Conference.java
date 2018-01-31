package com.thoughtworks.conference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Conference
 * <p>
 * Created by napoleon on 07/12/2016.
 */
public class Conference {
    private TrackItem trackItem;

    Conference(String[] inputs) {
        String input = inputs[0];

        String[] inputArray = input.split(" ");
        String durationString = inputArray[inputArray.length - 1];
        String title = input.substring(0, input.lastIndexOf(" "));
        //String startTime = durationString.substring(0, durationString.indexOf("min"));

        schedule(new Talk(new Duration(durationString), title));
    }

    private void schedule(Talk talk) {
        trackItem = talk.toTrackItem(new Time(21));
    }

    public List<Track> tracks() {
        return Stream.of(new Track(trackItem)).collect(Collectors.toList());
    }
}
