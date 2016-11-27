package com.thoughtworks.train.routesbuilder;

import com.thoughtworks.train.Graph;
import com.thoughtworks.train.Route;
import com.thoughtworks.train.Section;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Route Builder
 * <p>
 * Created by napoleon on 01/11/2016.
 */
public class RoutesBuilder {
    private String start;
    private String end;
    private List<Route> routes;
    private BuildCondition buildCondition;

    public RoutesBuilder() {
        this.routes = new ArrayList<>();
    }

    public RoutesBuilder startAt(String start) {
        this.start = start;
        return this;
    }

    public RoutesBuilder endAt(String end) {
        this.end = end;
        return this;
    }

    public List<Route> allRoutes() {
        sectionsStartWith(start).forEach(this::collectRoutesByCondition);
        return routes;
    }

    public Route shortestRoute() {
        sectionsStartWith(start).forEach(this::collectRoutes);
        Optional<Route> minRoute = routes.stream().min(Comparator.comparingInt(Route::distance));
        return minRoute.isPresent() ? minRoute.get() : new Route();
    }

    void setBuildCondition(BuildCondition buildCondition) {
        this.buildCondition = buildCondition;
    }

    private void collectRoutesByCondition(Section previousSection) {
        for (Section currentSection : sectionsStartWith(previousSection.end())) {
            currentSection.setPreviousSection(previousSection);
            if (currentSection.endWith(end) && buildCondition.canBuild(currentSection)) {
                routes.add(currentSection.generateRoute());
            }
            if (buildCondition.shouldStopBuild(currentSection)) {
                return;
            }
            collectRoutesByCondition(currentSection);
        }
    }

    private void collectRoutes(Section previousSection) {
        for (Section currentSection : sectionsStartWith(previousSection.end())) {
            currentSection.setPreviousSection(previousSection);
            if (currentSection.endWith(end)) {
                routes.add(currentSection.generateRoute());
                return;
            }
            if (Section.isRoundTrip(previousSection, currentSection)) {
                return;
            }
            collectRoutes(currentSection);
        }
    }

    private static List<Section> sectionsStartWith(String start) {
        return Graph.instance().sectionsStartWith(start);
    }
}