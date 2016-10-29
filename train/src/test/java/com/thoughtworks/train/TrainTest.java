package com.thoughtworks.train;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * train test
 * <p>
 * Created by napoleon on 29/10/2016.
 */
public class TrainTest {
    @Test
    public void distance_of_A_B_C_should_be_9() {
        Graph graph = new Graph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        Route abc = new Route(graph, "A-B-C");

        int distance = abc.distance();

        assertThat(distance, is(9));
    }
}
