package testpack;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello there");
        System.out.println("my test of idea");
        People people = new Teacher();
        people = new Student();
        people = new Teacher();
        people.setAge(12);
        people.setName("no body");
        people.setSex("mr");
        System.out.println(people.toString());
    }
}
