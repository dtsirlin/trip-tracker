package com.dtsirlin.trip_tracker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 06/02/2019
 * <p>
 * IncompleteTripTest
 * <p>
 * Tests the CompleteTrip class
 */

public class CompleteTripTest {

    @Test
    public void complete_Trip_From_Stop_1_To_Stop_2_Cost_Test() {
        String trip = "Stop1Stop2";
        String cost = CompleteTrip.getCosts().get(trip);
        assertEquals("$3.25", cost);
    }

    @Test
    public void complete_Trip_From_Stop_2_To_Stop_1_Cost_Test() {
        String trip = "Stop2Stop1";
        String cost = CompleteTrip.getCosts().get(trip);
        assertEquals("$3.25", cost);
    }

    @Test
    public void complete_Trip_From_Stop_2_To_Stop_3_Cost_Test() {
        String trip = "Stop2Stop3";
        String cost = CompleteTrip.getCosts().get(trip);
        assertEquals("$5.50", cost);
    }

    @Test
    public void complete_Trip_From_Stop_3_To_Stop_2_Cost_Test() {
        String trip = "Stop3Stop2";
        String cost = CompleteTrip.getCosts().get(trip);
        assertEquals("$5.50", cost);
    }

    @Test
    public void complete_Trip_From_Stop_1_To_Stop_3_Cost_Test() {
        String trip = "Stop1Stop3";
        String cost = CompleteTrip.getCosts().get(trip);
        assertEquals("$7.30", cost);
    }

    @Test
    public void complete_Trip_From_Stop_3_To_Stop_1_Cost_Test() {
        String trip = "Stop3Stop1";
        String cost = CompleteTrip.getCosts().get(trip);
        assertEquals("$7.30", cost);
    }
}