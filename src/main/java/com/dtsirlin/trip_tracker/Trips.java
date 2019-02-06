package com.dtsirlin.trip_tracker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Author: Daniel Tsirlin
 * Date created: 06/02/2019
 * Date last modified: 06/02/2019
 * <p>
 * Trips
 * <p>
 * Create data structure to hold trips that match tap ons and tap offs
 */

public class Trips {
    private List<List<String>> tripsOutRecords;
    private List<Map<String, String>> activeTrips;


    public Trips() {
        tripsOutRecords = new ArrayList<>();
        // an active trip means a user has touched on and not yet touched on or off again.  all 3 trip outcomes possibilities are open to happen
        activeTrips = new ArrayList<>();
    }

    public void processTap(List<String> record) {
        if (activeTrips.size() == 0) {
            addTapToActiveTrips(record);
        } else {
            if (existingTripForUserExists(record.get(6))) {
                processTrip(record, getActiveTripForPAN(record.get(6)));
                updateActiveTrips(record);
            } else {
                addTapToActiveTrips(record);
            }
        }
    }

    public boolean existingTripForUserExists(String pan) {
        for (Map<String, String> record : activeTrips) {
            if (record.get("PAN").equals(pan)) {
                return true;
            }
        }

        return false;
    }

    public Map<String, String> getActiveTripForPAN(String pan) {
        for (Map<String, String> record : activeTrips) {
            if (record.get("PAN").equals(pan)) {
                return record;
            }
        }

        return null;
    }

    public void addTapToActiveTrips(List<String> record) {
        Map<String, String> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("DateTimeUTC", record.get(1));
        // there should only be "on" tap types in this list because if an input tap is a tap off,
        // user should complete or cancel their trip and no longer be an active trip
        // if 2 tap on in a row, make first tap on in to an incomplete trip and then make second tap on the start of the current active trip for the user
        fieldsMap.put("TapType", "ON");
        fieldsMap.put("StopId", record.get(3));
        fieldsMap.put("CompanyId", record.get(4));
        fieldsMap.put("BusID", record.get(5));
        fieldsMap.put("PAN", record.get(6));

        activeTrips.add(fieldsMap);
    }

    public void processTrip(List<String> record, Map<String, String> recordForActiveTripForPan) {
        // the big boy that adds to output file!

        if (recordForActiveTripForPan == null) {
            System.out.println("Somehow couldn't find active trip with same PAN as PAN in currently processing input record");
        } else {
            List<String> addToTripsOut = new ArrayList<>();

            // Started
            addToTripsOut.add(recordForActiveTripForPan.get("DateTimeUTC"));

            // Finished
            addToTripsOut.add(record.get(1));

            // DurationSecs
            addToTripsOut.add(calculateDuration(recordForActiveTripForPan.get("DateTimeUTC"), record.get(1)));

            // FromStopId
            addToTripsOut.add(recordForActiveTripForPan.get("StopId"));

            // ToStopId
            addToTripsOut.add(record.get(3));

            // ChargeAmount
            addToTripsOut.add(calculateChargeAmount(record, recordForActiveTripForPan));

            // CompanyID
            addToTripsOut.add(recordForActiveTripForPan.get("CompanyId"));

            // BusID
            addToTripsOut.add(recordForActiveTripForPan.get("BusID"));

            // PAN
            addToTripsOut.add(recordForActiveTripForPan.get("PAN"));

            // Status
            addToTripsOut.add(calculateTripStatus(record, recordForActiveTripForPan));

            tripsOutRecords.add(addToTripsOut);
        }

    }

    public String calculateDuration(String start, String end) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            Date parsedStart = format.parse(start);
            Date parsedEnd = format.parse(end);
            Instant formattedStart = parsedStart.toInstant();
            Instant formattedEnd = parsedEnd.toInstant();
            long duration = ChronoUnit.SECONDS.between(formattedStart, formattedEnd);

            return String.valueOf(duration);
        } catch (ParseException e) {
            return "error with date";
        }
    }

    public String calculateChargeAmount(List<String> record, Map<String, String> recordForActiveTripForPan) {
        if (calculateTripStatus(record, recordForActiveTripForPan).equals("COMPLETED")) {
            String stopsPair = recordForActiveTripForPan.get("StopId") + record.get(3);
            return CompleteTrip.getCosts().get(stopsPair);
        } else if (calculateTripStatus(record, recordForActiveTripForPan).equals("INCOMPLETE")) {
            return IncompleteTrip.getCosts().get(recordForActiveTripForPan.get("StopId"));
        } else {
            return "$0.00";
        }
    }

    public String calculateTripStatus(List<String> record, Map<String, String> recordForActiveTripForPan) {
        if (record.get(2).equals("ON")) {
            return "INCOMPLETE";
        } else {
            if (record.get(3).equals(recordForActiveTripForPan.get("StopId"))) {
                return "CANCELLED";
            } else {
                return "COMPLETED";
            }
        }
    }

    public void updateActiveTrips(List<String> record) {
        int i = 0;

        for (Map<String, String> recordFromActiveTrips : activeTrips) {
            if (recordFromActiveTrips.get("PAN").equals(record.get(6))) {
                // in this case, we had an active trip for given PAN and second tap was "OFF",
                // thus trip has been processed to be completed
                // and we no longer need this PAN in the active trips
                if (record.get(2).equals("OFF")) {
                    activeTrips.remove(i);
                } else {
                    // in this case, new tap must be "ON"
                    // therefore, remove the previous active trip for given PAN
                    // since is has been processed as an incomplete trip
                    // and add new tap on as active trip for given PAN
                    activeTrips.remove(i);
                    addTapToActiveTrips(record);
                }
                break;
            }

            i++;
        }
    }

    public List<List<String>> getTripsOutRecords() {
        return tripsOutRecords;
    }

    public List<Map<String, String>> getActiveTrips() {
        return activeTrips;
    }
}
