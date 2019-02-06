package com.dtsirlin.trip_tracker.Utils;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 05/02/2019
 * <p>
 * CSVParser
 * <p>
 * Util class for helping with parsing an input csv file
 * and split it up based on the comma delimiter
 */

public class CSVParser {
    public static List<List<String>> parseFile(BufferedReader file) {
        List<List<String>> records = new ArrayList<>();
        String thisLine = null;

        try {
            while ((thisLine = file.readLine()) != null) {
                String[] values = thisLine.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }
}
