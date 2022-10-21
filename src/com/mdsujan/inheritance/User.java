package com.mdsujan.inheritance;

import java.time.LocalDate;

public class User {
    private final String id;
    private String name;
    private LocalDate dob;

    private static int count = 0;
    public User() {
        id = null;
    }

    public User(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        this.id = name.strip()+(++count); // strip the name of spaces then take first 4 chars and assign the count
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "com.mdsujan.finalKeyword.User{" +
                "id=" + id +
                ", name=" + name +
                ", dob=" + dob +
                '}';
    }
}
