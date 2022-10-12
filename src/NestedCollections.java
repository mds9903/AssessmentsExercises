import java.util.*;

// Nested Collections
// "1. Map of Lists/Sets
// Ex:
// Map of Manager -> Reportees
// Map of Date -> OrderList
// Map of (User/CustomerId , -> Map of ( Date -> ,Order) etc"
public class NestedCollections {
    static Scanner sc = new Scanner(System.in); // scanner object to be used by any of the methods of this class

    public static void main(String[] args) {

        HashMap<Manager, ArrayList<Reportee>> map = new HashMap<>(); // a nested collection; map of Manager -> List of Reportees

        boolean running = true; // for continuous menu
        do {
            System.out.println("welcome to Org Console");
            System.out.println("MENU" +
                    "\n\t1. Display Managers and their Reportees" +
                    "\n\t2. Add a new manager (with no Reportees)" +
                    "\n\t3. Assign reportess to an existing manager using manager id" +
                    "\n\t4. Exit Console");
            System.out.println("Enter your choice");

            String input = sc.nextLine();
            // check for invalid input of choice; user enters a string instead of an int
            while (!isInteger(input)) {
                System.out.println("You entered a string. Please input a number like 1,2,etc");
                input = sc.nextLine();
            }
            int ch = Integer.parseInt(input);// convert validated input string to an int representing option choice
            switch (ch) {
                case 1:
                    // display the map of managers and their reportees
                    System.out.println(map);
                    break;
                case 2:
                    // create a new manager (only manager)
                    Manager newMgr = createNewManager(map);
                    System.out.println("New manager created" +
                            "\nNew Manager: " + newMgr);
                    break;
                case 3:
                    // Add new reportees and assign to an existing manager using manager id
                    if (assignManager(map)) {
                        System.out.println("Manager assigned successfully");
                    } else {
                        System.out.println("Sorry; something is wrong. Could not assign manager.");
                    }
                    break;
                case 4:
                    // exit console
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input. Please a valid option 1,2,3 or 4");
            }
        } while (running);
        System.out.println("Exiting. Thank you.");
    }

    private static boolean assignManager(HashMap<Manager, ArrayList<Reportee>> map) {
        ArrayList<Reportee> newReportees = createNewReporteeList(); // create a new list of reportees
        // get the manager to whom these new reporteees should be assigned
        System.out.println("Enter the manager id of manager who should be assigned to these new reportees");
        int id = sc.nextInt();
        // finding the manager with the id
//        Set<Manager> mgrSet = map.keySet(); // all the managers in map
        for (Manager mgr : map.keySet()) {
            if (mgr.getId() == id) {
                // manager found
                map.put(mgr, newReportees); // add the new reportees to the found manager
                return true; // operation successful
            }
        }
        return false;
    }

    private static ArrayList<Reportee> createNewReporteeList() {
        ArrayList<Reportee> newReportees = new ArrayList<>();
        System.out.println("Enter the number of new reportees");
        int n = sc.nextInt();
        sc.nextLine(); // to clear the buffer caused due nextInt();
        System.out.println("Enter the new reportees' details");
        for (int i = 1; i <= n; i++) {
            System.out.println("New reportee #" + i);
            System.out.println("Enter name");
            String name = sc.nextLine();
            System.out.println("Enter designation");
            String designation = sc.nextLine();
            newReportees.add(new Reportee(name, designation)); // create a new reportee object and add to the list of reportees
        }
        return newReportees;
    }

    private static Manager createNewManager(HashMap<Manager, ArrayList<Reportee>> map) {
        System.out.println("Enter the details for new Manager");
        System.out.println("Enter Manager Name ");
        String name = sc.nextLine();
        System.out.println("Enter Manager Branch ");
        String branch = sc.nextLine();
        Manager newMgr = new Manager(name, branch);
        map.put(newMgr, null); // no reportees since this is a new manager
        return newMgr;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            // returns true if the given string is an integer
            return true;
        } catch (NumberFormatException numEx) {
            return false;// else false
        }
    }

}
