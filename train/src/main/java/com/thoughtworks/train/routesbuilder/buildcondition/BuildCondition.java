package com.thoughtworks.train.routesbuilder.buildcondition;

import com.thoughtworks.train.Section;

/**
 * BuildCondition
 * <p>
 * Created by napoleon on 21/11/2016.
 */
public interface BuildCondition {
    boolean shouldStopBuild(Section section);
    boolean canBuild(Section section);
}