package com.paravar.practice.practice17.datatime;

import java.time.*;

public class TestDateTime {
    public static void main(String[] args) {

        localDate();
        localTime();
        localDateTime();
        zonedDateTime();

        period();
        duration();


        instant();
        clock();
    }

    public static void localDate() {
        LocalDate today = LocalDate.now();                // current date
        LocalDate birthDate = LocalDate.of(1990, 5, 20); // specific date

        System.out.println("Today: " + today);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Tomorrow: " + today.plusDays(1));
        System.out.println("Last Week: " + today.minusWeeks(1));
    }

    public static void localTime() {
        LocalTime now = LocalTime.now();             // current time
        LocalTime lunch = LocalTime.of(13, 0);      // 1:00 PM

        System.out.println("Now: " + now);
        System.out.println("Lunch Time: " + lunch);
        System.out.println("In 2 hours: " + now.plusHours(2));
    }

    public static void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime meeting = LocalDateTime.of(2025, 9, 25, 10, 30,34);

        System.out.println("Now: " + now);
        System.out.println("Meeting: " + meeting);
    }

    public static void zonedDateTime() {
        ZonedDateTime nowInIndia = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime nowInNY = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println("India Time: " + nowInIndia);
        System.out.println("New York Time: " + nowInNY);
    }

    //. Period – Difference in Dates
    public static void period(){
        LocalDate birth = LocalDate.of(1995, 2, 10);
        LocalDate today = LocalDate.now();

        Period age = Period.between(birth, today);

        System.out.println("Age: " + age.getYears() + " years " +
                age.getMonths() + " months " +
                age.getDays() + " days");
    }

    // Duration – Difference in Times
    public static void duration() {
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 30);

        Duration workHours = Duration.between(start, end);

        System.out.println("Work hours: " + workHours.toHours() + " hours");
    }

    /*
    1. Instant – a machine timestamp
    Represents a point on the UTC timeline (like UNIX timestamp in seconds/nanoseconds).
    Good for logging, comparing events, storing in DB, etc.
    * */
    public static void instant() {
        Instant now = Instant.now();                       // current timestamp (UTC)
        System.out.println("Now: " + now);

        Instant tenSecondsLater = now.plusSeconds(10);     // add 10 seconds
        System.out.println("10s Later: " + tenSecondsLater);

        Duration diff = Duration.between(now, tenSecondsLater);
        System.out.println("Difference: " + diff.getSeconds() + " seconds");
    }

    /*
    2. Clock – abstraction for current time
    Provides the current date-time from a particular time zone.
    Useful for testing (you can mock Clock instead of relying on System.currentTimeMillis()).
    * */

    public static void clock() {
        Clock systemUTC = Clock.systemUTC();   // system clock in UTC
        Clock systemDefault = Clock.systemDefaultZone(); // system clock in local zone

        Instant instant = systemUTC.instant();
        System.out.println("UTC Instant: " + instant);

        ZonedDateTime dateTimeInKolkata = ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Kolkata")));
        System.out.println("India Time: " + dateTimeInKolkata);

        // Custom fixed clock (for testing)
        Clock fixedClock = Clock.fixed(Instant.parse("2025-01-01T00:00:00Z"), ZoneId.of("UTC"));
        System.out.println("Fixed Clock: " + fixedClock.instant());
    }
}
