import java.util.*;

// Nested Collections
// "1. Map of Lists/Sets
// Ex:
// Map of Manager -> Reportees
// Map of Date -> OrderList
// Map of (User/CustomerId , -> Map of ( Date -> ,Order) etc"
public class NestedCollections {
    public static void main(String[] args) {
        // a nested collection
        // map is a hashmap of manager IDs to the map of managers and thier reportees
        // {MgrID , [list of Reportees]}
        // reportess is an arraylist of reportee objects
        Map<Integer, ArrayList<Reportee>> map = new HashMap<>();

        boolean running = false;

        do {
            System.out.println("welcome to Org Console");
            System.out.println("MENU" +
                    "\n\t1. Display Managers and their Reportees" +
                    "\n\t2. Add a new manager (with no Reportees)" +
                    "\n\t3. Add new Reportees and assign to a manager using manager id" +
                    "\n\t4. Exit Console");
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            while (!isInteger(input)) {
                System.out.println("You entered a string. Please input a number like 1,2,etc");
                input = sc.nextLine();
            }
            int ch = Integer.parseInt(input);
            switch (ch) {
                case 1:
                    // display the map of mangers and their reportees
                    System.out.println(map);
                    break;
                case 2:
                    // create a new manager
                    map.put(createNewManager().getId(), null); // add the newly created manager to the map with no reportees as of now
                    break;
                case 3:
                    // Add new reportees and assign to a manager using manager id

                    // create a new list of reportees
                    ArrayList<Reportee> newReportees = createNewReporteeList(); // create a new list of reportees

                    // input the id of the manager the new reportees should be assigned to
                    System.out.println("Enter the manager id to assign these new reportees");
                    int mgrId = sc.nextInt();
                    if (Manager.getManagerById(mgrId) != null) {
                        // if manager found then add these new reportees to that manager
                        map.put(mgrId, newReportees);
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
    }

    private static ArrayList<Reportee> createNewReporteeList() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Reportee> newReportees = new ArrayList<>();
        System.out.println("Enter the number of new reportees");
        int n = sc.nextInt();
        System.out.println("Enter the new reportees' details");
        for (int i = 1; i <= n; i++) {
            System.out.println("New reportee #" + i);
            System.out.println("Enter name");
            String name = sc.nextLine();
            System.out.println("Enter designation");
            String designation = sc.nextLine();
            newReportees.add(new Reportee(name, designation));
        }
        return newReportees;
    }

    private static Manager createNewManager() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details for new Manager");
        System.out.println("Enter Manager Name ");
        String name = sc.nextLine();
        System.out.println("Enter Manager Branch ");
        String branch = sc.nextLine();
        return new Manager(name, branch);
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
