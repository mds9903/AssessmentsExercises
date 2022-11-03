package com.mdsujan.singleton;

public class Cable {
    private int length;

    // a private static instance
    private static Cable cable;

    // a private constructor
    private Cable() {
    }

    private Cable(int length) {
        this.length = length;
    }

    public static Cable getInstance(int length) {
        if (cable == null) {
            // the single object has not been created yet
            cable = new Cable(length); // return private static instance
        }
        return cable; // return the already created (static) instance
    }

    public static Cable getInstance() {
        if (cable == null) {
            // the single object has not been created yet
            cable = new Cable(); // return private static instance
        }
        return cable; // return the already created (static) instance
    }
}
