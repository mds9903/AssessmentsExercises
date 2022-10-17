import java.util.Scanner;

//"Accessing methods/variables without instantiating the class.
//Where these would be helpful?"
public class StaticKeyword {
    // a static scanner so we can use it to take input in any function in the program
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // the class User also uses a static class variable called count
        // this helps keep the count of user objects created during the execution of the program
        User user1 = new User("Md", "Sujan");
        User user2 = new User("Tim", "Lee");
        // also the count is used to create unique id for each user
        System.out.println(user1.toString());
        System.out.println(user2.toString());
    }
}
