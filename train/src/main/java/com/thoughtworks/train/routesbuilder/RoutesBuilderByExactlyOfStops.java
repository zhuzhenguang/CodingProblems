package com.thoughtworks.train.routesbuilder;

/**
 * RoutesBuilderByExactlyOfStops
 * <p>
 * Created by napoleon on 21/11/2016.
 */
public class RoutesBuilderByExactlyOfStops extends RoutesBuilder {
    public RoutesBuilderByExactlyOfStops(int exactlyOfStops) {
        setAllowCircle();
        setBuildCondition(new StopsEqualCondition(exactlyOfStops));
    }
}
