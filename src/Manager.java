import javax.lang.model.element.Name;
import java.util.HashMap;

public class Manager {
    private static HashMap<Integer, Manager> managers;
    private static int count;
    private String name;
    private String branch;
    private int id;

    Manager(String name, String branch){
        this.name = name;
        this.branch = branch;
        this.id = Manager.count++;
        Manager.managers.put(this.id, this); // update than map of existing managers
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

    public static Manager getManagerById(int id){
        return Manager.managers.getOrDefault(id, null);
    }
}
