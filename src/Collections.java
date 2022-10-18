import java.util.*;
//import java.util.ArrayList;
//import java.util.List;

// "Initialize collections inline
// 1. ArrayList
// 2. Sets
// 3. Maps"
public class Collections {
    public static void main(String[] args) {
        // init an arraylist inline using an array
        // method 1
        // using Arrays.asList(array)
        // method 2
        // using Collections.addAll(array)
        // method 3
        // using List.of(-the-array-of-the-elements-)
        // arraylist
        System.out.println("ArrayList");
        List<Integer> listNums = new ArrayList<>(List.of(new Integer[]{1,2,3,4,5,6,8}));
        System.out.println(listNums);
        List<String> listVowels = new ArrayList<>(List.of(new String[]{"a", "e", "i", "o", "u"}));
        System.out.println(listVowels);

        // sets
        System.out.println("Sets");
        Set<Integer> setIntegers = new HashSet<>(List.of(new Integer[]{1,2,3,4,5,6,8})); // maintains order
        System.out.println(setIntegers);
        Set<Character> setVowels = Set.of('a', 'e', 'i', 'o', 'u'); // does not maintain order
        System.out.println(setVowels);

        // maps
        System.out.println("Maps");
        Map<Integer, String> mapWeekdays = new HashMap<>(Map.of(
                1, "Monday",
                2, "Tuesday",
                3, "Wednesday",
                4, "Thursday",
                5, "Friday",
                6, "Saturday",
                7, "Sunday"));
        System.out.println(mapWeekdays);
    }
}
