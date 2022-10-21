package com.mdsujan.timeModule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

public class TimeModule {
    static String dmyPattern = "dd/MM/uuuu";

    public static void main(String[] args) {
        // Find the days remaining for next birthday
        // Ask for the birth date and
        // if date falls in last month say already done
        // else show months / days / hours remaining
        // code
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your birth date in 'DD/MM/YYYY' format");
//        String input = sc.next();// take user input of date as string
//        LocalDateTime dob = getDateObj(input); // convert to date
//        while (dob == null) {// validate input for date
//            // else ask the user to input again
//            System.out.println("invalid date entered.Please enter in 'DD/MM/YYYY' format" +
//                    "\nExample: '23/09/2022'");
//            input = sc.next();
//            dob = getDateObj(input);
//        }

        String input = "15/10/1997";
        LocalDate dob = getDateObj(input);

        // if valid
        // find the number of hours between currentDT and birth date
        LocalDateTime currentDT = LocalDateTime.now();
        System.out.println("current dt "+ getDateString(currentDT) +" "+ currentDT.toString().substring(11));

        LocalDateTime bdayDT = getDateObj(input.substring(0, 6) + currentDT.getYear()).atTime(0,0);
        System.out.println("You bday this year " + getDateString(bdayDT));
        if(bdayDT.getMonthValue() < currentDT.getMonthValue()) // bday was last month
        {
            System.out.println("Your birthday already done");
        }else{
            long diffHours = Math.abs(HOURS.between(bdayDT, currentDT));
//            System.out.println(diffHours);
            // print the difference as
            // m months, d days and h hours remaining
            int months = (int) (diffHours / (30*24));
            diffHours %= (30*24);
            int days = (int) diffHours / 24;
            diffHours %= 24;
            System.out.println((months > 0 ? months+" months, " : "")
                                +""+ (days > 0 ? days+" days, and " : "")
                                +""+(diffHours > 0 ? diffHours+" hours until your birthday" : ""));
        }
    }

    private static LocalDate getDateObj(String input) {
        // check the given string for a valid ddmmyyy date
        DateTimeFormatter dmyFormatter = DateTimeFormatter.ofPattern(TimeModule.dmyPattern);
        try {
            return LocalDate.parse(input, dmyFormatter);
        } catch (DateTimeParseException dtExp) {
            return null;
        }
    }

    private static String getDateString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(TimeModule.dmyPattern)).toString().substring(0, 10);
    }

}
