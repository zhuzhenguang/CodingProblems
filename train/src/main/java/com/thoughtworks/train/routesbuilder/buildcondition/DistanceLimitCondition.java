package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

public class DistanceLimitCondition implements BuildCondition {
    private int limitDistance;

    public DistanceLimitCondition(int limitDistance) {
        this.limitDistance = limitDistance;
    }

    @Override
    public boolean shouldStopBuild(Section section) {
        return section.distance() >= limitDistance;
    }

    @Override
    public boolean canBuild(Section section) {
        return section.distance() < limitDistance;
    }
}
