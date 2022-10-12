import java.util.Objects;
import java.util.Stack;

public class Practice<E> {
    private E practiceNum;

    Practice(E value){
        this.practiceNum = value;
    }

    public E getPracticeNum() {
        return practiceNum;
    }

    @Override
    public String toString() {
        return "this Practice object has practiceNum = "+this.practiceNum;
    }

    public void setPracticeNum(E practiceNum) {
        this.practiceNum = practiceNum;
    }

    public static void main(String[] args) {
        String str1 = "hello"; // literal
        String str2 = "hello"; // literal
        str2 = "bye"; // creates a new literal in the string pool
        String str3 = new String("hello"); // new object

        System.out.println(str1==str2); // not values only addresses
        System.out.println(str1==str3);
        System.out.println(str1==str3);
        System.out.println(str1.equals(str3)); // lexicoghraphically comparison; i.e, values
        System.out.println(str1.equals(str2));

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);
        sb.append(" world");
        System.out.println(sb);
        Practice<Integer> pI = new Practice<>(12);
        System.out.println(pI);
        Practice<Integer> pI2 = new Practice<>(13);
        System.out.println(pI2);
        str1 = str1+" world";
        Stack<Object> stack = new Stack<>();
        stack.push(12);
        stack.push("hello");
        stack.push(new Practice<Integer>(10));
    }
}
