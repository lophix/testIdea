package testpack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authuor Administrator
 * @Create 2016-11-23-10:19
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("hello");
        list1.add("hello");
        list.add("bye");
        list1.add("morning");
        list.retainAll(list1);
        list.forEach(System.out::println);
        list1.forEach((s) -> System.out.print(s + ";"));
        System.out.println();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.stream().mapToDouble(Double::valueOf).forEach(System.out::println);
    }
}
