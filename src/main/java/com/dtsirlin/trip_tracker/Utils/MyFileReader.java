package com.dtsirlin.trip_tracker.Utils;

import com.dtsirlin.trip_tracker.Exceptions.NotACsvFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 05/02/2019
 * <p>
 * MyFileReader
 * <p>
 * Util class for helping with reading an input file and making sure it is a file with extension .csv
 */

public class MyFileReader {
    private static Scanner scanner = new Scanner(System.in);

    public static BufferedReader readInFile() throws NotACsvFileException, IOException {
        System.out.println("\nEnter file name: ");
        String fileName = scanner.next();

        return checkFileName(fileName);
    }

    public static BufferedReader checkFileName(String fileName) throws NotACsvFileException, IOException {
        try {
            if (!fileName.substring(fileName.length() - 4).equals(".csv")) {
                throw new NotACsvFileException("File must be .csv file!");
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new NotACsvFileException("File name is too short to be a .csv file (must be at least 5 characters!)");
        }

        return new BufferedReader(new FileReader(fileName));
    }
}