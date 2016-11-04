package pattern.decorator;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-17:18
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Person person = new Shirt(new Skirt(new Person("nico")));
        person.show();
    }
}
