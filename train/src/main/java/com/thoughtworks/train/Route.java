package com.thoughtworks.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Route
 * <p>
 * Created by napoleon on 29/10/2016.
 */
public class Route {
    private List<Section> sections;

    Route() {
        this.sections = new ArrayList<>();
    }

    Route(String routePath) {
        this();
        initializeSections(routePath);
    }

    Route(Section initialSection) {
        this();
        addSection(initialSection);
    }

    private void initializeSections(String routePath) {
        String[] stations = routePath.split("-");
        for (int i = 0; i < stations.length - 1; i++) {
            addSection(new Section(stations[i], stations[i + 1]));
        }
    }

    void addSection(Section section) {
        sections.add(section);
    }

    int distance() {
        return sections.stream().mapToInt(Section::distance).sum();
    }
}