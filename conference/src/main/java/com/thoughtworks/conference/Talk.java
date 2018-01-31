package com.thoughtworks.conference;

/**
 * Created by napoleon on 05/12/2016.
 */
public class Talk {
    private String title;

    Talk(Duration duration, String title) {
        this.title = title;
    }

    public TrackItem toTrackItem(Time time) {
        return new TrackItem(time, title);
    }
}
