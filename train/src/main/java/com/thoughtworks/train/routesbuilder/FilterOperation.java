package com.thoughtworks.train.routesbuilder;

/**
 * FilterOperation
 * <p>
 * Created by napoleon on 21/11/2016.
 */
interface FilterOperation {
    boolean operate(int sectionCount, int stops);
}

class EqOperation implements FilterOperation {
    @Override
    public boolean operate(int sectionCount, int stops) {
        return sectionCount == stops;
    }
}

class LeOperation implements FilterOperation {
    @Override
    public boolean operate(int sectionCount, int stops) {
        return sectionCount <= stops;
    }
}