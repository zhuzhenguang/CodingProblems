package com.thoughtworks.train.routesbuilder;

import com.thoughtworks.train.Graph;
import com.thoughtworks.train.Route;
import com.thoughtworks.train.Section;
import com.thoughtworks.train.routesbuilder.buildcondition.BuildCondition;

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

    public RoutesBuilder withCondition(BuildCondition condition) {
        this.buildCondition = condition;
        return this;
    }

    public List<Route> allRoutes() {
        Graph.instance().sectionsStartWith(start).forEach(this::collectRoutes);
        return routes;
    }

    public Route shortestRoute() {
        Optional<Route> shortestRoute = allRoutes().stream().min(Comparator.comparingInt(Route::distance));
        return shortestRoute.orElseGet(Route::new);
    }

    private void collectRoutes(Section previousSection) {
        for (Section currentSection : Graph.instance().sectionsFrom(previousSection)) {
            if (buildCondition.canBuild(currentSection, end)) {
                routes.add(currentSection.generateRoute());
            }
            if (buildCondition.shouldStopBuild(currentSection, end)) {
                return;
            }
            collectRoutes(currentSection);
        }
    }
}