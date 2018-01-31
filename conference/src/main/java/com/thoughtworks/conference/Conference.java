package com.thoughtworks.conference;

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
        InputParser inputParser = new InputParser(input);
        schedule(new Talk(new Duration(inputParser.durationString()), inputParser.title()));
    }

    private void schedule(Talk talk) {
        trackItem = talk.toTrackItem(new Time(21));
    }

    public List<Track> tracks() {
        return Stream.of(new Track(trackItem)).collect(Collectors.toList());
    }
}
