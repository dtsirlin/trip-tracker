# Trip Tracker
Calculate those trip costs!

Author: Daniel Tsirlin
## Setup
Steps before being able to test or run the application.

### Pre-requisites
- Install Java 8 (best chance of working with Java 8u192 as it was developed with that version).  Make sure it is on your path.
 
### Build
Navigate in terminal/command prompt to the project folder with the *build.gradle* file (this will be project root folder by default) and execute `$ ./gradlew clean build` on Mac OS X or `.\gradlew clean build` on Windows.

## Running
How to test and run the application.

### Test
Navigate in terminal/command prompt to the project folder with the *build.gradle* file (this will be project root folder by default) and execute `$ ./gradlew test` on Mac OS X or `.\gradlew test` on Windows.

Test results will be generated at *./build/reports/tests/test/index.html* on MacOS X or *.\build\reports\tests\test\index.html* on Windows.

### Run Application

Once built, navigate in terminal/command prompt to the project folder with the *build.gradle* file (this will be project root folder by default)  and execute `$ java -cp ./build/libs/trip_tracker-0.0.1.jar com.dtsirlin.trip_tracker.Main`.

## Assumptions
- File with taps can be any name and exist at any location when reading in file name
- Read in file must have extension .csv
- Values must be separated by commas with no space after a comma
    - "src/test/resources/testParsingCSV.csv" shows an example of removing spaces after a comma from the example input file given in the coding exercise briefing document
- An incomplete trip will occur if a user (noted by their unique PAN) has 2 tap ons in a row, thus the trip based on the first tap on is incomplete
- The program won't process trips where a user has tapped on but not tapped on or off again before the input file ended.  This is because we can't yet be sure what the customer would do next after the input file stopped with data and it wouldn't be fair to charge them until their next tap.
- A tap for a given PAN cannot have TapType "OFF" unless the preceeding tap for that given PAN had TapType "ON"
- Output will write CompanyId and BusID of the first tap in a pair of taps to the output file, so if they differ between the two taps, oh well

## Notes on my dev
- For testing, I tested each method as I went.  I started off developing and testing the smaller classes (the Utils, Complete/IncompleteTrip).  When I got up to the more business logic classes, I realised I wouldn't have enough time to thoroughly test everything.  Thus, I printed out the output of the business logic to the console and compared what I saw in the console to what I wrote down on paper as to the expect outcome based on the 3 test resources.

## TODO:
- Write array of trip records to csv file (didn't do to spend less time on this, even though it shouldn't take too much time given the data structure for the records is pretty convenient)
- Have more thorough and higher coverage tests.