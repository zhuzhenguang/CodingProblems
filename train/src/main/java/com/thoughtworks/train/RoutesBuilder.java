package com.thoughtworks.train;

import java.util.ArrayList;
import java.util.List;

/**
 * Route Builder
 * <p>
 * Created by napoleon on 01/11/2016.
 */
class RoutesBuilder {
    private String start;
    private String end;
    private int maximumOfStops;
    private List<Route> routes;

    RoutesBuilder() {
        routes = new ArrayList<>();
    }

    RoutesBuilder startAt(String start) {
        this.start = start;
        return this;
    }

    RoutesBuilder endAt(String end) {
        this.end = end;
        return this;
    }

    RoutesBuilder withMaximumOfStops(int maximumOfStops) {
        this.maximumOfStops = maximumOfStops;
        return this;
    }

    List<Route> get() {
        collectRoutes(start, end, new Route());
        return routes;
    }

    private void collectRoutes(String start, String end, Route route) {
        if (route.sectionCount() == maximumOfStops) {
            return;
        }
        for (Section section : Graph.instance().sections()) {
            if (section.equals(new Section(start, end))) {
                route.addSection(section);
                routes.add(route);
                route = new Route();
                continue;
            }
            if (section.startWith(start)) {
                route.addSection(section);
                collectRoutes(section.end(), end, route);
            }
        }
    }
}
