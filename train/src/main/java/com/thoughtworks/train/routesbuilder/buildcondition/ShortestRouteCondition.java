package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

/**
 * ShortestRouteCondition
 * <p>
 * Created by napoleon on 27/11/2016.
 */
public class ShortestRouteCondition extends BuildCondition {
    @Override
    public boolean shouldStopBuild(Section section, String end) {
        return section.isRoundTrip() || super.canBuild(section, end);
    }

    @Override
    public boolean canBuild(Section section, String end) {
        return super.canBuild(section, end);
    }
}
