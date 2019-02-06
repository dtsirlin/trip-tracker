package com.dtsirlin.trip_tracker.Exceptions;

import org.junit.Test;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 05/02/2019
 * <p>
 * NotACsvFileExceptionTest
 * <p>
 * Tests the NotACsvFileException exception
 */

public class NotACsvFileExceptionTest {
    @Test(expected = NotACsvFileException.class)
    public void throws_Not_A_Txt_File_Exception_Test() throws NotACsvFileException {
        throw new NotACsvFileException("Testing NotACsvFileException exception works!");
    }
}