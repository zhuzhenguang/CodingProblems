package com.thoughtworks.train;

import java.util.Objects;

/**
 * Section
 * <p>
 * Created by napoleon on 29/10/2016.
 */
class Section extends Route {
    private String start;
    private String end;
    private int distance;

    Section(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    Section(String start, String end) {
        this(start, end, -1);
    }

    @Override
    int distance() {
        if (distance < 0) {
            distance = Graph.instance().getDistanceOf(this);
        }
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(start, section.start) &&
                Objects.equals(end, section.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
