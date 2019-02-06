package com.dtsirlin.trip_tracker.Utils;

import com.dtsirlin.trip_tracker.Exceptions.NotACsvFileException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 05/02/2019
 * <p>
 * MyFileReaderTest
 * <p>
 * Tests the MyFileReader class
 */

public class MyFileReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_Throw_Exception_If_Filename_Under_4_Characters_Test() throws NotACsvFileException, IOException {
        thrown.expect(NotACsvFileException.class);
        thrown.expectMessage("File name is too short to be a .csv file (must be at least 5 characters!)");
        MyFileReader.checkFileName("123");
    }

    @Test
    public void should_Throw_Exception_If_Filename_Does_Not_Have_Txt_Extension_Test() throws NotACsvFileException, IOException {
        thrown.expect(NotACsvFileException.class);
        thrown.expectMessage("File must be .csv file!");
        MyFileReader.checkFileName("notacsvfile.ceeessvee");
    }
}