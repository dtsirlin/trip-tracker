package com.dtsirlin.trip_tracker;

import com.dtsirlin.trip_tracker.Exceptions.NotACsvFileException;
import com.dtsirlin.trip_tracker.Utils.CSVParser;
import com.dtsirlin.trip_tracker.Utils.Menu;
import com.dtsirlin.trip_tracker.Utils.MyFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 06/02/2019
 * <p>
 * GenerateTrips
 * <p>
 * Reads in input taps file,
 * processes taps and
 * outputs trips to trips.csv
 */


public class GenerateTrips {
    private static Scanner scanner = new Scanner(System.in);

    public GenerateTrips() {
    }

    public void run() {
        System.out.println(Menu.welcomeMessage());
        System.out.println(Menu.mainMenu());
        boolean quit = false;

        while (!quit) {
            System.out.print("\nPlease enter your choice: ");
            String menuOption = scanner.next();
            switch (menuOption) {
                case "1":
                    readTapsCsv();
                    break;
                case "2":
                    System.out.println(Menu.mainMenu());
                    break;
                case "3":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again!\n");
                    break;
            }
        }

        System.out.println(Menu.quitMessage());
    }

    public void readTapsCsv() {
        // try read in file first
        BufferedReader file = null;
        try {
            file = MyFileReader.readInFile();
        } catch (IOException e) {
            System.out.println("File not found, please try again!");
            return;
        } catch (NotACsvFileException e) {
            System.out.println(e.getMessage());
            return;
        }

        parseInput(file);
    }

    public void parseInput(BufferedReader file) {
        List<List<String>> parsedInput = CSVParser.parseFile(file);

        processInput(parsedInput);
    }

    public void processInput(List<List<String>> parsedInput) {
        Trips trips = new Trips();

        for (List<String> record : parsedInput) {
            trips.processTap(record);
        }

        printOutput(trips.getTripsOutRecords());
        writeFile(trips.getTripsOutRecords());
    }

    public void printOutput(List<List<String>> tripsOut) {
        System.out.println("\nStarted, Finished, DurationSecs, FromStopId, ToStopId, ChargeAmount, CompanyId, BusID, PAN, Status");
        for (List<String> record : tripsOut) {
            int i = 0;
            for (String field : record) {
                if ((i + 1) == record.size()) {
                    System.out.print(field);
                } else {
                    System.out.print(field + ", ");
                }
                i++;
            }
            System.out.println();
        }
    }

    public void writeFile(List<List<String>> tripsOut) {
        // TODO:
        // create file in (in roof folder of application) called trips.csv and write to it line by line tripsOut
        // where first line in the file are the tiltes for columns
    }
}
