package com.mdsujan.objectComparisons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

//"Define a class representing a real life Object.
// E.g. com.mdsujan.finalKeyword.User/ com.mdsujan.collectionsModifications.Employee / Address / Bank Account / etc.
// Create a collection of objects.
// Perform following Ops:
// 1. Sort the list of objects
// 2. Select objects meeting certain criteria from the list
// 3. What is required to ensure the uniqueness of the objects?
// 4. Build map from list"
public class StreamsCollections {
    static String dateFormat = "d/MM/yyyy";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample POJO
        /*
            "com.mdsujan.collectionsModifications.Employee {
            firstname,
            lastname,
            dateofjoining,
            experience,
            dateOfbirth,
            department,
            managername,
            designation
            }"
        */
        List<Employee> empList = new ArrayList<Employee>(); // collection of employees to work with
        empList.add(
                new Employee(
                        "Tom", "Lee",
                        getDateIn("12/12/2022", dateFormat),
                        2,
                        getDateIn("03/03/1999", dateFormat),
                        "Client",
                        "Robert William",
                        "SE"));
        empList.add(
                new Employee(
                        "Raj", "Kumar",
                        getDateIn("12/12/2021", dateFormat),
                        1,
                        getDateIn("03/03/1997", dateFormat),
                        "Product",
                        "Robert William",
                        "Sr SE"));
        empList.add(
                new Employee(
                        "Will", "Dorrington",
                        getDateIn("01/11/2020", dateFormat),
                        3,
                        getDateIn("03/03/1993", dateFormat),
                        "Product",
                        "Robert William",
                        "Lead SE"));
        empList.add(
                new Employee(
                        "David", "Broker",
                        getDateIn("12/11/2021", dateFormat),
                        2,
                        getDateIn("03/03/1993", dateFormat),
                        "Client",
                        "Pawan Singhal",
                        "Jr SE"));
//        populateList(empList); // populate the list of employees either by user input or hard code

        // sample operations:-
        // sort by last name

        // method 1: using comparator and sort
        /*empList.sort(new Comparator<com.mdsujan.collectionsModifications.Employee>() {
            @Override
            public int compare(com.mdsujan.collectionsModifications.Employee a, com.mdsujan.collectionsModifications.Employee b) {
                return a.getLastname().compareTo(b.getLastname());
            }
        });
        System.out.println("sorted by last name:\n" + empList);*/

        // method 2: using streams
        System.out.println("sort by names\n" + sortByLastName(empList));
        System.out.println();

        // sort by date of joining
        System.out.println("sort by doj\n" + sortByDOJ(empList));
        System.out.println();

        // employees with more than 2 years of exp
        System.out.println("filter by 2 years exp\n" + filterByExp(empList, 2));
        System.out.println();

        // employees with a specific designation
        System.out.println("employees in IT designation\n" + filterByDesignation(empList, "IT"));
        System.out.println();

        // group employees by manager name
        System.out.println("emp grouped by managers\n" + filterByMngrName(empList, "Sunil"));
        System.out.println();

        // group by year of birth
        System.out.println("group by dob\n" + groupByDOB(empList));
        System.out.println();

        // group by year of joining
        System.out.println("sort by doj\n" + groupByDOJ(empList));
        System.out.println();

        // make of set of manager names
        System.out.println("All managers\n" + getManagersSet(empList));
        System.out.println();

    }

    private static Set<String> getManagersSet(List<Employee> empList) {
        Set<String> mgrNamesSet = empList.stream()
                .map(Employee::getManagername)
                .collect(Collectors.toSet());
        return mgrNamesSet;
    }

    private static Map<LocalDate, List<Employee>> groupByDOJ(List<Employee> empList) {
        Map<LocalDate, List<Employee>> empGroupedByDOJ = empList.stream()
                .sorted((e1, e2) -> e1.getDateofjoining().compareTo(e2.getDateofjoining()))
                .collect(groupingBy(Employee::getDateofjoining));
        return empGroupedByDOJ;
    }

    private static Map<LocalDate, List<Employee>> groupByDOB(List<Employee> empList) {
        Map<LocalDate, List<Employee>> empGroupedByDOB = empList.stream()
                .sorted((e1, e2) -> e1.getDateOfbirth().compareTo(e2.getDateOfbirth()))
                .collect(groupingBy(Employee::getDateOfbirth));
        return empGroupedByDOB;
    }

    private static List<Employee> filterByMngrName(List<Employee> empList, String mgrName) {
        List<Employee> empUnderMgr = empList.stream()
                .filter(employee -> employee.getManagername().equals(mgrName))
                .collect(Collectors.toList());
        return empUnderMgr;
    }

    private static List<Employee> filterByDesignation(List<Employee> empList, String designation) {
        List<Employee> empOfDesig = empList.stream()
                .filter(employee -> employee.getDesignation().equals(designation))
                .collect(Collectors.toList());
        return empOfDesig;
    }

    private static List<Employee> filterByExp(List<Employee> empList, int exp) {
        List<Employee> filtered = empList.stream()
                .filter(employee -> employee.getExperience() == exp)
                .collect(Collectors.toList());
        return filtered;
    }

    private static List<Employee> sortByDOJ(List<Employee> empList) {
        List<Employee> empByDOJ = empList.stream()
                .sorted((e1, e2) -> e1.getDateofjoining().compareTo(e2.getDateofjoining()))
                .collect(Collectors.toList());
        return empByDOJ;
    }

    private static List<Employee> sortByLastName(List<Employee> empList) {
        List<Employee> empByLastName = empList.stream()
                .sorted((e1, e2) -> e1.getLastname().compareTo(e2.getLastname()))
                .collect(Collectors.toList());
        return empByLastName;
    }

    private static void populateList(List<Employee> empList) {

        // populate the given list
        System.out.println("Enter the number of employees you want to add");
        int n = sc.nextInt();
        sc.nextLine(); // clearing the buffer
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter employee details for employee #" + i);
            System.out.println("First Name");
            String fname = sc.nextLine();
            System.out.println("Last Name");
            String lname = sc.nextLine();
            System.out.println("Date of joining in DD/MM/YYYY format");
            String dojStr = sc.next();
            sc.nextLine();// clearing the buffer
            LocalDate dojDate = getDateIn(dateFormat, dojStr);
            System.out.println("Experience in years: ");
            int exp = sc.nextInt();
            sc.nextLine();// clearing the buffer
            System.out.println("Date of Birth in DD/MM/YYYY format");
            String dobStr = sc.next();
            sc.nextLine();// clearing the buffer
            LocalDate dobDate = getDateIn(dateFormat, dobStr);
            System.out.println("Department name");
            String dept = sc.nextLine();
            System.out.println("com.mdsujan.nestedCollections.Manager name");
            String mgrName = sc.nextLine();
            System.out.println("Designation");
            String desig = sc.nextLine();

            empList.add(new Employee(fname, lname, dojDate, exp, dobDate, dept, mgrName, desig));
        }
    }


    private static LocalDate getDateIn(String dateStr, String formatStr) {
        // check the given string for a valid ddmmyyy date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException dtExp) {
            return null;
        }
    }
}
