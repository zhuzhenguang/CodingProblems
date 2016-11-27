package com.thoughtworks.train;

import java.util.Objects;

/**
 * Section
 * <p>
 * Created by napoleon on 29/10/2016.
 */
public class Section implements Cloneable {
    private String start;
    private String end;
    private int distance;

    private Section previousSection;

    Section() {
    }

    Section(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.previousSection = Section.empty();
    }

    Section(String start, String end) {
        this(start, end, -1);
    }

    public int distance() {
        if (distance < 0) {
            distance = Graph.instance().getDistanceOf(this);
        }
        return distance + previousSection.distance();
    }

    boolean startWith(String start) {
        return this.start.equals(start);
    }

    public boolean endWith(String end) {
        return this.end().equals(end);
    }

    public String end() {
        return end;
    }

    public String start() {
        return start;
    }

    public void setPreviousSection(Section previousSection) {
        this.previousSection = previousSection;
    }

    public int sectionNo() {
        return previousSection.sectionNo() + 1;
    }

    public Route generateRoute() {
        Route route = previousSection.generateRoute();
        route.addSection(this);
        return route;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Section(start, end, distance);
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

    static Section empty() {
        return new NullSection();
    }

    public static boolean isRoundTrip(Section previousSection, Section nextSection) {
        return nextSection.endWith(previousSection.start());
    }
}
