package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

public class StopsEqualCondition implements BuildCondition {
    private int exactlyOfStops;

    public StopsEqualCondition(int exactlyOfStops) {

        this.exactlyOfStops = exactlyOfStops;
    }

    @Override
    public boolean shouldStopBuild(Section section) {
        return canBuild(section);
    }

    @Override
    public boolean canBuild(Section section) {
        return section.sectionNo() == exactlyOfStops;
    }
}
