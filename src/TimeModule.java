import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

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
//        LocalDate dob = getDateObj(input);
//        while (dob == null) {// validate input for date
//            // else ask the user to input again
//            System.out.println("invalid date entered.Please enter in 'DD/MM/YYYY' format" +
//                    "\nExample: '23/09/2022'");
//            input = sc.next();
//            dob = getDateObj(input);
//        }
//        String input = "23/11/2001";
//        String input = "12/09/1997";
        String input = "15/10/1997";
        LocalDate dob = getDateObj(input);
        // if valid
        // find the number of days between today and birth date
        LocalDate today = LocalDate.now();
//        System.out.println(DAYS.between(today, dob)); // give error why?
        LocalDate thisYearBday = getDateObj(input.substring(0, 6) + today.getYear());
        System.out.println("You bday this year " + thisYearBday);
        assert thisYearBday != null;
        long diffDays = DAYS.between(thisYearBday, today);
        if(diffDays >= 30) // bday was last month
        {
            System.out.println("Your birthday already done");
        }else{
            int hours = 24 * (int)Math.abs(diffDays);
//            System.out.println("Days remaining until your bday " + Math.abs(diffDays) + " days");
            // print the difference as
            // m months, d days and h hours remaining
            System.out.println(hours / (30*24)+" months"); // months
            hours %= 30 * 24;
            System.out.println(hours / 24+" days");
            hours %= 24;
            System.out.println(hours+" hours");
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

    private static String getDateString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(TimeModule.dmyPattern)).toString().substring(0, 10);
    }

}
