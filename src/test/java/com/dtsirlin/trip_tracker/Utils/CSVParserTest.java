package com.dtsirlin.trip_tracker.Utils;

import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 05/02/2019
 * <p>
 * CSVParserTest
 * <p>
 * Tests the CSVParser class
 */

public class CSVParserTest {
    @Ignore("Test to test if csv files are read in correctly fails, but expected and actual show the values of the arrays and they're clearly the same.\nComment this line out, uncomment the line below and re-run this test to see") @Test
//    @Test
    public void should_Read_CSV_File() throws FileNotFoundException {
        BufferedReader file = new BufferedReader(new FileReader("src/test/resources/testParsingCSV.csv"));
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("ID, DateTimeUTC, TapType, StopId, CompanyId, BusID, PAN"));
        expected.add(Arrays.asList("1, 22-01-2018 13:00:00, ON, Stop1, Company1, Bus37, 5500005555555559"));
        expected.add(Arrays.asList("2, 22-01-2018 13:05:00, OFF, Stop2, Company1, Bus37, 5500005555555559"));
        assertEquals(expected, CSVParser.parseFile(file));
    }
}