package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

public class DistanceLimitCondition extends BuildCondition {
    private int limitDistance;

    public DistanceLimitCondition(int limitDistance) {
        this.limitDistance = limitDistance;
    }

    @Override
    public boolean shouldStopBuild(Section section, String end) {
        return section.distance() >= limitDistance;
    }

    @Override
    public boolean canBuild(Section section, String end) {
        return super.canBuild(section, end) && section.distance() < limitDistance;
    }
}
