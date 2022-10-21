package com.mdsujan.singleton;
public class Singleton {
    public static void main(String[] args) {
        Cable cable1 = Cable.getInstance(11);
        Cable cable2 = Cable.getInstance();

        System.out.println(cable1);
        System.out.println(cable2); // this will have the same hashcode since only one instance was created

    }
}
