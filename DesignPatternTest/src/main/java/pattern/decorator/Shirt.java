package pattern.decorator;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-17:15
 */
public class Shirt extends Decorator{
    public Shirt(Person person) {
        super(person);
    }

    @Override
    public void show() {
        System.out.println("======== shirt ======");
        super.show();
    }
}
