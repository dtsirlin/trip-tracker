package com.dtsirlin.trip_tracker.Utils;

/**
 * Author: Daniel Tsirlin
 * Date created: 05/02/2019
 * Date last modified: 05/02/2019
 * <p>
 * Menu
 * <p>
 * Facilitates printing a menu for the application
 */


public class Menu {
    public static String welcomeMessage() {
        return "***** Welcome *****";
    }

    public static String mainMenu() {
        return "\nMenu:\n" +
                "1.\tRead in file.\n" +
                "2.\tShow menu options.\n" +
                "3.\tQuit.";
    }

    public static String quitMessage() {
        return "\nExiting...";
    }
}
