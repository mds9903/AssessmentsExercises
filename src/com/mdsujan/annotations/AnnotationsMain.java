package com.mdsujan.annotations;

import java.util.Locale;

//Define a custom annotation and demo its use.
public class AnnotationsMain {
    public static void main(String[] args) {
        Animal sherKhan = new Tiger("Sher Khan", "female", "meat", "12kg");
        Animal tommy = new Dog("Tommy", "male", "bones and treats", "2 bones");

        System.out.println(canKeepPet(sherKhan));
        System.out.println(canKeepPet(tommy));

    }

    private static String canKeepPet(Animal animal) {
        if (animal.getClass().isAnnotationPresent(Domestic.class)) {
            return animal.getName() + " is domestic; we can keep " + getPronoun(animal) + " in our house";
        }
        return animal.getName() + " is a wild one; we should let " + getPronoun(animal) + " be in the wild habitat";
    }

    private static String getPronoun(Animal animal) {
        return animal.getGender().toLowerCase().charAt(0) == 'm' ? "him" : "her";
    }
}
