package com.thoughtworks.train;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * train test
 * <p>
 * Created by napoleon on 29/10/2016.
 */
public class TrainTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void given_graph() {
        Graph.initialize("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
    }

    @Test
    public void distance_of_A_B_C_should_be_9()  {
        Route abc = new Route("A-B-C");

        int distance = abc.distance();

        assertThat(distance, is(9));
    }

    @Test
    public void distance_of_A_D_should_be_5()  {
        Route ad = new Route("A-D");

        int distance = ad.distance();

        assertThat(distance, is(5));
    }

    @Test
    public void distance_of_A_D_C_should_be_13()  {
        Route adc = new Route("A-D-C");

        int distance = adc.distance();

        assertThat(distance, is(13));
    }

    @Test
    public void distance_of_A_E_B_C_D_should_be_22()  {
        Route aebcd = new Route("A-E-B-C-D");

        int distance = aebcd.distance();

        assertThat(distance, is(22));
    }

    @Test
    public void distance_of_A_E_D_should_be_NO_SUCH_ROUTE()  {
        Route aed = new Route("A-E-D");

        thrown.expect(NoSuchRouteException.class);
        thrown.expectMessage("NO SUCH ROUTE");

        aed.distance();
    }
}
