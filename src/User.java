public class User {
    private String firstName;
    private String lastName;

    public final String id;

    private static int count = 0;

    User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = firstName.substring(0, 3) + (++count);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }
//    public void setId(String newId) {
//        this.id = newId;
//    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
