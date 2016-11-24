package com.thoughtworks.train;

/**
 * NullSection
 * <p>
 * Created by napoleon on 24/11/2016.
 */
public class NullSection extends Section {
    NullSection() {
        super();
    }

    @Override
    int distance() {
        return 0;
    }

    @Override
    public int sectionNo() {
        return 0;
    }

    @Override
    public Route generateRoute() {
        return new Route();
    }
}
