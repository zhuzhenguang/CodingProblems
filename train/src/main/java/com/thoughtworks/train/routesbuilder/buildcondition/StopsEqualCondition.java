package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

public class StopsEqualCondition extends BuildCondition {
    private int exactlyOfStops;

    public StopsEqualCondition(int exactlyOfStops) {
        this.exactlyOfStops = exactlyOfStops;
    }

    @Override
    public boolean shouldStopBuild(Section section, String end) {
        return section.sectionNo() == exactlyOfStops;
    }

    @Override
    public boolean canBuild(Section section, String end) {
        return super.canBuild(section, end) && section.sectionNo() == exactlyOfStops;
    }
}
