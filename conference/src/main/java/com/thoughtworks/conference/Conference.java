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
    public Conference(String[] inputs) {

    }

    public List<Track> tracks() {
        return Stream.of(new Track()).collect(Collectors.toList());
    }
}
