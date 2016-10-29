package com.thoughtworks.train;

/**
 * Created by napoleon on 29/10/2016.
 */
class Section extends Route {
    private String start;
    private String end;
    private int distance;

    Section(String start, String end) {
        this.start = start;
        this.end = end;
    }

    Section(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    int distance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        return start != null ? start.equals(section.start) : section.start == null && (end != null ? end.equals(section.end) : section.end == null);

    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}
