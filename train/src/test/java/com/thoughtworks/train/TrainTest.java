package com.thoughtworks.train;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * train test
 * <p>
 * Created by napoleon on 29/10/2016.
 */
public class TrainTest {
    @BeforeClass
    public static void given_graph() {
        Graph.initialize("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
    }

    @Test
    public void distance_of_A_B_C_should_be_9() {
        Route abc = new Route("A-B-C");

        int distance = abc.distance();

        assertThat(distance, is(9));
    }

    @Test
    public void distance_of_A_D_should_be_5() {
        Route ad = new Route("A-D");

        int distance = ad.distance();

        assertThat(distance, is(5));
    }

    @Test
    public void distance_of_A_D_C_should_be_13() {
        Route adc = new Route("A-D-C");

        int distance = adc.distance();

        assertThat(distance, is(13));
    }
}
