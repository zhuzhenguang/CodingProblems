package com.thoughtworks.train.routesbuilder;

import com.thoughtworks.train.Graph;
import com.thoughtworks.train.Route;
import com.thoughtworks.train.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Route Builder
 * <p>
 * Created by napoleon on 01/11/2016.
 */
public class RoutesBuilder {
    private String start;
    private String end;
    private List<Route> routes;
    private FilterOperation filterOperation;
    private int filterStops;

    RoutesBuilder() {
        routes = new ArrayList<>();
    }

    public RoutesBuilder startAt(String start) {
        this.start = start;
        return this;
    }

    public RoutesBuilder endAt(String end) {
        this.end = end;
        return this;
    }

    public List<Route> get() {
        Graph.instance().sectionsStartWith(start).forEach(this::collectRoutes);
        return routes;
    }

    void setFilterOperation(FilterOperation filterOperation) {
        this.filterOperation = filterOperation;
    }

    void setFilterStops(int filterStops) {
        this.filterStops = filterStops;
    }

    private void collectRoutes(Section previousSection) {
        for (Section section : Graph.instance().sectionsStartWith(previousSection.end())) {
            section.setPreviousSection(previousSection);
            if (section.endWith(end) && filterOperation.operate(section.sectionNo(), filterStops)) {
                routes.add(section.generateRoute());
                return;
            }
            if (section.sectionNo() == filterStops) {
                return;
            }
            collectRoutes(section);
        }
    }
}