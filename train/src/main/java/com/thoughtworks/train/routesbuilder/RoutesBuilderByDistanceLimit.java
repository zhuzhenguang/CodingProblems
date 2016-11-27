package com.thoughtworks.train.routesbuilder;

/**
 * RoutesBuilderByDistanceLimit
 * <p>
 * Created by napoleon on 27/11/2016.
 */
public class RoutesBuilderByDistanceLimit extends RoutesBuilder {
    public RoutesBuilderByDistanceLimit(int limitDistance) {
        setBuildCondition(new DistanceLimitOperation(limitDistance));
    }
}
