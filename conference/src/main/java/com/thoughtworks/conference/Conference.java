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
    private final Track track;

    Conference(String[] inputs) {
        track = new Track();

        for (String input : inputs) {
            InputParser inputParser = new InputParser(input);
            schedule(new Talk(
                    new Duration(inputParser.durationString()),
                    inputParser.title()));
        }
    }

    private void schedule(Talk talk) {
        track.addTalk(talk);
    }

    public List<Track> tracks() {
        return Stream.of(track).collect(Collectors.toList());
    }
}
