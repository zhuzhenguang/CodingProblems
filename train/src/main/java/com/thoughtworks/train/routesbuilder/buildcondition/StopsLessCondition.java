package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

public class StopsLessCondition implements BuildCondition {
    private int maximumOfStops;

    public StopsLessCondition(int maximumOfStops) {
        this.maximumOfStops = maximumOfStops;
    }

    @Override
    public boolean shouldStopBuild(Section section) {
        return section.sectionNo() == maximumOfStops;
    }

    @Override
    public boolean canBuild(Section section) {
        return section.sectionNo() <= maximumOfStops;
    }
}
