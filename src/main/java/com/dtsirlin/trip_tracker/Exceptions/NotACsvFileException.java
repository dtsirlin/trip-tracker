package com.dtsirlin.trip_tracker.Exceptions;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 05/02/2019
 * <p>
 * NotACsvFileException
 * <p>
 * Exception for when a target read in file isn't a file with extension .csv
 */

public class NotACsvFileException extends Exception {
    public NotACsvFileException(String message) {
        super(message);
    }
}
