package com.mdsujan.collectionsModifications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CollectionsModifications {
    //"Iterate over the collection and remove the element based on some condition
    //Ex:
    //1. Remove the employees from list joined before a date
    //2. Remove ErrorCodes of 4XX types from a Set of all the response codes
    //3. Remove the Entries from Map
    //
    //Adavanced:
    //Modify/filter a list if some parameter values is present in some Set type collection.
    //and similar"
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // set of employees
        Set<Employee> employees = new HashSet<>();

        boolean running = true;
        do {
            System.out.println("Welcome to com.mdsujan.collectionsModifications.Employee Management Console");
            System.out.println("****** Options ****** ");
            System.out.println("1.\tAdd 1 or more new employee(s)\n" +
                    "2.\tRemove an employee using EmployeeID\n" +
                    "3.\tRemove all employees joined before a particular date\n" +
                    "4.\tDisplay all employees\n" +
                    "5.\tExit Console\n");
            System.out.println("Enter your choice of option 1,2,3,4 or 5");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    // add employee
                    System.out.println("Enter the number of employees to add");
                    int n = scanner.nextInt();
                    if (addEmp(employees, n)) {
                        System.out.println("Adding employee(s) successful");
                    } else {
                        System.out.println("Adding employee(s) failed");
                    }
                    break;
                case 2:
                    // remove employee by id
                    System.out.println("Enter the id of the employee you want to remove");
                    String id = scanner.next();
                    if (removeById(employees, id)) {
                        System.out.println("Removing employee successful");
                    } else {
                        System.out.println("Removing employee failed");
                    }
                    break;
                case 3:
                    // remove employee(s) joined before a date
                    System.out.println("Enter the date of joining in DD/MM/YYYY format");
                    String input = scanner.next();
                    Date doj = dmyToDate(input);
                    if (removeBeforeDoj(employees, doj)) {
                        System.out.println("Removing employee(s) successful");
                    } else {
                        System.out.println("Removing employee(s) failed");
                    }
                    break;
                case 4:
                    // display all employees
                    System.out.println("all employees currently in system");
                    System.out.println(employees);
                    break;
                case 5:
                    System.out.println("Exiting");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
        } while (running);
    }

    private static boolean removeBeforeDoj(Set<Employee> employees, Date doj) {
        Iterator<Employee> itr = employees.iterator();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        while (itr.hasNext()) {
            Employee emp = itr.next();
            if (emp.getDateOfJoining().compareTo(doj) < 0) {
                System.out.println("Removing emp: "+emp);
                itr.remove();
//                employees.remove(emp);
            }
        }
        return true;
    }

    private static boolean removeById(Set<Employee> employees, String id) {
        Iterator<Employee> itr = employees.iterator();
        while (itr.hasNext()) {
            Employee emp = itr.next();
            if (emp.getId().equals(id)) {
                System.out.println("Removing emp: " + emp);
                return employees.remove(emp);
            }
        }
        return false;
    }

    private static boolean addEmp(Set<Employee> employees, int n) {
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter full name: ");
            String name = scanner.nextLine();
            System.out.println("Enter date of joining or leave blank to use current date");
            String strDate = scanner.next();
            Date doj = dmyToDate(strDate);
//            if(doj == null){
//                doj = new Date();
//            }
            if (employees.add(new Employee(name, doj)) == false) return false;
            scanner.nextLine();
        }
        return true;
    }

    private static Date dmyToDate(String strDate) {
        if (strDate == "") {
            return null;
        }
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
