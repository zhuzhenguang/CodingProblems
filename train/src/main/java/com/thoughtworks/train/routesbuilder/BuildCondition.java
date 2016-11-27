package com.thoughtworks.train.routesbuilder;

import com.thoughtworks.train.Section;

/**
 * BuildCondition
 * <p>
 * Created by napoleon on 21/11/2016.
 */
interface BuildCondition {
    boolean shouldStopBuild(Section section);

    boolean canBuild(Section section);
}

class StopsEqualCondition implements BuildCondition {
    private int exactlyOfStops;

    StopsEqualCondition(int exactlyOfStops) {

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

class StopsLessCondition implements BuildCondition {
    private int maximumOfStops;

    StopsLessCondition(int maximumOfStops) {
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

class NullCondition implements BuildCondition {
    @Override
    public boolean shouldStopBuild(Section section) {
        return false;
    }

    @Override
    public boolean canBuild(Section section) {
        return true;
    }
}

class DistanceLimitOperation implements BuildCondition {
    private int limitDistance;

    DistanceLimitOperation(int limitDistance) {
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