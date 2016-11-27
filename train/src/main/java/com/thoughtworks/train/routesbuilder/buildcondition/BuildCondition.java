package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

/**
 * BuildCondition
 * <p>
 * Created by napoleon on 27/11/2016.
 */
public abstract class BuildCondition {
    public abstract boolean shouldStopBuild(Section section, String end);

    public boolean canBuild(Section section, String end) {
        return section.endWith(end);
    }
}
