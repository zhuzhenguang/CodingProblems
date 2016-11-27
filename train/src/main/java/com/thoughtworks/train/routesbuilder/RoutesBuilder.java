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
    private boolean allowCircle;

    public RoutesBuilder() {
        this.routes = new ArrayList<>();
        this.allowCircle = false;
        setBuildCondition(new NullCondition());
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
        Graph.instance().sectionsStartWith(start).forEach(this::collectRoutes);
        return routes;
    }

    public Route shortestRoute() {
        Optional<Route> minRoute = allRoutes().stream().min(Comparator.comparingInt(Route::distance));
        return minRoute.isPresent() ? minRoute.get() : new Route();
    }

    void setBuildCondition(BuildCondition buildCondition) {
        this.buildCondition = buildCondition;
    }

    void setAllowCircle() {
        this.allowCircle = true;
    }

    private void collectRoutes(Section previousSection) {
        for (Section currentSection : Graph.instance().sectionsStartWith(previousSection.end())) {
            currentSection.setPreviousSection(previousSection);
            if (currentSection.endWith(end) && buildCondition.canBuild(currentSection)) {
                routes.add(currentSection.generateRoute());
                if (!allowCircle) {
                    return;
                }
            }
            if (buildCondition.shouldStopBuild(currentSection)) {
                return;
            }
            if (currentSection.endWith(previousSection.start()) && !allowCircle) {
                return;
            }
            collectRoutes(currentSection);
        }
    }
}