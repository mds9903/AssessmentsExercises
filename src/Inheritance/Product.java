package Inheritance;

public class Product {
    private String name;
    private String id;
    private static int count = 0;

    public Product() {
        count++;
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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public Product(String name) {
        this.name = name;
        this.id = name.strip() + (int) (Math.random() * 11) + (++count);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
