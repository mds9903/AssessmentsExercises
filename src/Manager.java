import javax.lang.model.element.Name;
import java.util.HashMap;

public class Manager {
    private static int count = 1;
    private String name;
    private String branch;
    private final int id;

    private HashMap<Integer, Reportee> reportees;


    Manager(String name, String branch) {
        this.name = name;
        this.branch = branch;
        this.id = Manager.count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }


}
