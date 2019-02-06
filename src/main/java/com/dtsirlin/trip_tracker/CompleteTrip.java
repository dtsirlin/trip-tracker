package com.dtsirlin.trip_tracker;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 06/02/2019
 * <p>
 * CompleteTrip
 * <p>
 * Contains reference for costs for complete trips depending on touch on and touch off locations
 */

public class CompleteTrip {
    private static Map<String, String> costs = new LinkedHashMap<String, String>() {{
        put("Stop1Stop2", "$3.25");
        put("Stop2Stop1", "$3.25");
        put("Stop2Stop3", "$5.50");
        put("Stop3Stop2", "$5.50");
        put("Stop1Stop3", "$7.30");
        put("Stop3Stop1", "$7.30");
    }};

    public static Map<String, String> getCosts() {
        return costs;
    }
}