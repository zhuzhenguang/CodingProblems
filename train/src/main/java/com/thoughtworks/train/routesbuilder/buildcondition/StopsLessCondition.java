package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

public class StopsLessCondition extends BuildCondition {
    private int maximumOfStops;

    public StopsLessCondition(int maximumOfStops) {
        this.maximumOfStops = maximumOfStops;
    }

    @Override
    public boolean shouldStopBuild(Section section, String end) {
        return section.sectionNo() == maximumOfStops;
    }

    @Override
    public boolean canBuild(Section section, String end) {
        return super.canBuild(section, end) && section.sectionNo() <= maximumOfStops;
    }
}
