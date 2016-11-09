package com.thoughtworks.train;

import java.util.ArrayList;
import java.util.List;

/**
 * Route
 * <p>
 * Created by napoleon on 29/10/2016.
 */
class Route {
    private List<Section> sections;

    Route() {
        this.sections = new ArrayList<>();
    }

    Route(String routePath) {
        this();
        initializeSections(routePath);
    }

    private void initializeSections(String routePath) {
        String[] stations = routePath.split("-");
        for (int i = 0; i < stations.length - 1; i++) {
            sections.add(new Section(stations[i], stations[i + 1]));
        }
    }

    boolean startWith(String start) {
        return true;
    }

    void addSection(Section section) {
        sections.add(section);
    }

    int sectionCount() {
        return sections.size();
    }

    int distance() {
        return sections.stream().mapToInt(Section::distance).sum();
    }
}