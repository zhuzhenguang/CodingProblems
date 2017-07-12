package com.thoughtworks.train;

import com.thoughtworks.train.routesbuilder.RoutesBuilder;
import com.thoughtworks.train.routesbuilder.buildcondition.DistanceLimitCondition;
import com.thoughtworks.train.routesbuilder.buildcondition.ShortestRouteCondition;
import com.thoughtworks.train.routesbuilder.buildcondition.StopsEqualCondition;
import com.thoughtworks.train.routesbuilder.buildcondition.StopsLessCondition;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

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

    @Test
    public void distance_of_A_E_B_C_D_should_be_22() {
        Route aebcd = new Route("A-E-B-C-D");

        int distance = aebcd.distance();

        assertThat(distance, is(22));
    }

    @Test
    public void distance_of_A_E_D_should_be_NO_SUCH_ROUTE() {
        Route aed = new Route("A-E-D");

        thrown.expect(NoSuchRouteException.class);
        thrown.expectMessage("NO SUCH ROUTE");

        aed.distance();
    }

    @Test
    public void there_are_2_routes_from_C_to_C_with_maximum_of_3_stops() {
        List<Route> routes = new RoutesBuilder()
                .startAt("C")
                .endAt("C")
                .withCondition(new StopsLessCondition(3))
                .allRoutes();

        int numberOfRoutes = routes.size();

        assertThat(numberOfRoutes, is(2));
    }

    @Test
    public void there_are_3_routes_from_A_to_C_with_exactly_4_stops() {
        List<Route> routes = new RoutesBuilder()
                .startAt("A")
                .endAt("C")
                .withCondition(new StopsEqualCondition(4))
                .allRoutes();

        int numberOfRoutes = routes.size();

        assertThat(numberOfRoutes, is(3));
    }

    @Test
    public void length_of_the_shortest_route_from_A_to_C_should_be_9() {
        Route shortestRoute = new RoutesBuilder()
                .startAt("A")
                .endAt("C")
                .withCondition(new ShortestRouteCondition())
                .shortestRoute();

        int distance = shortestRoute.distance();

        assertThat(distance, is(9));
    }

    @Test
    public void length_of_the_shortest_route_from_B_to_B_should_be_9() {
        Route shortestRoute = new RoutesBuilder()
                .startAt("B")
                .endAt("B")
                .withCondition(new ShortestRouteCondition())
                .shortestRoute();

        int distance = shortestRoute.distance();

        assertThat(distance, is(9));
    }

    @Test
    public void there_are_7_routes_from_C_to_C_with_a_distance_of_less_than_30() {
        List<Route> routes = new RoutesBuilder()
                .startAt("C")
                .endAt("C")
                .withCondition(new DistanceLimitCondition(30))
                .allRoutes();

        int numberOfRoutes = routes.size();

        assertThat(numberOfRoutes, is(7));
    }
}