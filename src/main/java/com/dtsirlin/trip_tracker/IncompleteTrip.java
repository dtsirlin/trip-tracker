package com.dtsirlin.trip_tracker;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 06/02/2019
 * <p>
 * IncompleteTrip
 * <p>
 * Contains reference for costs for incomplete trips depending on touch on location
 */

public class IncompleteTrip {
    private static Map<String, String> costs = new LinkedHashMap<String, String>() {{
        put("Stop1", "$7.30");
        put("Stop2", "$5.50");
        put("Stop3", "$7.30");
    }};

    public static Map<String, String> getCosts() {
        return costs;
    }
}
