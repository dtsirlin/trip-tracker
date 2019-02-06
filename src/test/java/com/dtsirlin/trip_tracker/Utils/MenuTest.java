package com.dtsirlin.trip_tracker.Utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 05/02/2019
 * <p>
 * MenuTest
 * <p>
 * Tests the Menu class
 */

public class MenuTest {
    @Test
    public void welcomeMessage() {
        String expected = "***** Welcome *****";
        assertEquals(expected, Menu.welcomeMessage());
    }

    @Test
    public void mainMenu() {
        String expected = "\nMenu:\n" +
                "1.\tRead in file.\n" +
                "2.\tShow menu options.\n" +
                "3.\tQuit.";
        assertEquals(expected, Menu.mainMenu());
    }

    @Test
    public void quitMessage() {
        String expected = "\nExiting...";
        assertEquals(expected, Menu.quitMessage());
    }
}