package ObjectComparisons;

import java.time.LocalDate;

public class Employee {
    private String firstname;
    private String lastname;
    private LocalDate dateofjoining;
    private int experience;
    private LocalDate dateOfbirth;
    private String department;
    private String managername;
    private String designation;

    public Employee() {

    }

    public Employee(String firstname, String lastname, LocalDate dateofjoining, int experience,
                    LocalDate dateOfbirth, String department, String managername, String designation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofjoining = dateofjoining;
        this.experience = experience;
        this.dateOfbirth = dateOfbirth;
        this.department = department;
        this.managername = managername;
        this.designation = designation;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(LocalDate dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return " {" +
                " | " + firstname  +
                " | " + lastname  +
                " | " + dateofjoining +
                " | " + experience +
                " | " + dateOfbirth +
                " | " + department  +
                " | " + managername  +
                " | " + designation  +
                "} ";
    }


}
