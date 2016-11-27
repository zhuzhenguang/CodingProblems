package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

/**
 * ShortestRouteCondition
 * <p>
 * Created by napoleon on 27/11/2016.
 */
public class ShortestRouteCondition implements BuildCondition {
    @Override
    public boolean shouldStopBuild(Section section) {
        return false;
    }

    @Override
    public boolean canBuild(Section section) {
        return true;
    }
}
