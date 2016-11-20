package com.thoughtworks.train.routesbuilder;

/**
 * RoutesBuilderByMaximumOfStops
 * <p>
 * Created by napoleon on 21/11/2016.
 */
public class RoutesBuilderByMaximumOfStops extends RoutesBuilder {
    public RoutesBuilderByMaximumOfStops(int maximumOfStops) {
        super();
        setFilterStops(maximumOfStops);
        setFilterOperation(new LeOperation());
    }
}
