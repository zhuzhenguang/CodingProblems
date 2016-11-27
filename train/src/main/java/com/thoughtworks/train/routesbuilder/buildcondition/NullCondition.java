package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

public class NullCondition implements BuildCondition {
    @Override
    public boolean shouldStopBuild(Section section) {
        return false;
    }

    @Override
    public boolean canBuild(Section section) {
        return true;
    }
}
