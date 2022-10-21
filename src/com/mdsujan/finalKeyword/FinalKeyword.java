package com.mdsujan.finalKeyword;

import java.util.Scanner;
//Explain usage and working of final keyword through a simple programme
public class FinalKeyword {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        User user = new User("Mohammed", "Sujan");
        System.out.println(user.toString());
        // lets try to change the id which is a final instance variable
//        user.setId("Hello123"); // this wont run; a compile time error occurs on the com.mdsujan.finalKeyword.User class where the setId() function is defines
        // even if the id was made public
        // let's change the access for id to public in class com.mdsujan.finalKeyword.User
        // and try to change the value of id for obj user
//        user.id = "hello123"; // this will cause again a compile time error in FinalKeyword.java since id is a final instance variable of user
    }
}
