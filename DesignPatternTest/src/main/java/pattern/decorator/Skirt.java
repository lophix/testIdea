package pattern.decorator;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-17:15
 */
public class Skirt extends Decorator {
    public Skirt(Person person) {
        super(person);
    }

    @Override
    public void show() {
        System.out.println("======== skirt ========");
        super.show();
    }
}
