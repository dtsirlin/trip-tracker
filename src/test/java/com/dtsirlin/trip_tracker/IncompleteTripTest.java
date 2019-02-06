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
 * Tests the IncompleteTrip class
 */

public class IncompleteTripTest {
    @Test
    public void incomplete_Trip_From_Stop_1_Cost_Test() {
        String cost = IncompleteTrip.getCosts().get("Stop1");
        assertEquals("$7.30", cost);
    }

    @Test
    public void incomplete_Trip_From_Stop_2_Cost_Test() {
        String cost = IncompleteTrip.getCosts().get("Stop2");
        assertEquals("$5.50", cost);
    }

    @Test
    public void incomplete_Trip_From_Stop_3_Cost_Test() {
        String cost = IncompleteTrip.getCosts().get("Stop3");
        assertEquals("$7.30", cost);
    }
}