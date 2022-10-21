package com.mdsujan.collectionsModifications;

import java.util.Date;

public class Employee {
    private static int count = 0;
    private String name;
    private String id;
    private Date dateOfJoining;

    public Employee(String name, Date doj) {
        this.name = name;
        this.dateOfJoining = doj;
        this.id = name.substring(0, 3) + ++count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "com.mdsujan.collectionsModifications.Employee{" + "\nname: " + name + "\nid: " + id + "\ndateOfJoining: " + dateOfJoining + "}";
    }
}
