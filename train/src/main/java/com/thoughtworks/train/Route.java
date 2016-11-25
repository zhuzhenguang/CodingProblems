package com.thoughtworks.train;

/**
 * Route
 * <p>
 * Created by napoleon on 29/10/2016.
 */
public class Route {
    private Section lastSection;

    Route() {
        lastSection = Section.empty();
    }

    Route(String routePath) {
        this();
        initializeSections(routePath);
    }

    private void initializeSections(String routePath) {
        String[] stations = routePath.split("-");
        for (int i = 0; i < stations.length - 1; i++) {
            addSection(new Section(stations[i], stations[i + 1]));
        }
    }

    void addSection(Section section) {
        section.setPreviousSection(lastSection);
        lastSection = section;
    }

    int distance() {
        return lastSection.distance();
    }
}