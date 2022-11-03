package com.mdsujan.dateFormatting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateFormatting {
    // assessment qn# 14:
    // Write a Java programme, with couple of data formatting options for user to select from terminal,
    // and then display the current date time in the selected format
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        String[] formats = {"dd/MM/YYYY HH:mm:ss", "MM/dd/YYYY HH:mm:ss aa", "YYYY/MM/dd hh:mm:ss"}; // all the date format strings
        boolean running = true; // for continuous display of menu
        do {
            System.out.println("Welcome to date formatter console" +
                                    "Choose the option of Date format" +
                                    "\n1. DD/MM/YYYY HH:mm:ss" +
                                    "\n2. MM/DD/YYYY hh:mm:ss aa" +
                                    "\n3. YYYY/MM/DD" +
                                    "\n4. Exit the console");
            System.out.println("\n\tEnter your choice: 1,2,3 or 4");
            String ch = sc.next(); // in case user enters some string instead of integer
            int option; // init to an option that is invalid in the menu options, i.e., any number > 4
            try{
                option = Integer.parseInt(ch); // we convert the string into an option number
            }catch (NumberFormatException numEx){
                System.out.println(numEx);
                return; // end this program
            }
            if (option > 0 && option < 4) {
                // get the index based on option; index = option - 1
                // and get the corresponding format to convert the date
                // getDateIn(format, date): returns the given 'date' in the given 'format' string eg; mm/dd/yyyy
                System.out.println(getDateIn(formats[option-1], date));
            } else if (option == 4) {
                System.out.println("Exiting"); // user selected to exit the console
                running = false; // end the loop
            } else {
                System.out.println("Wrong option selected. Please try again.");
            }
        } while (running);
        System.out.println("Thank you. Bye.");
    }

    private static String getDateIn(String formatString, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatString);
        return formatter.format(date);
    }
}
