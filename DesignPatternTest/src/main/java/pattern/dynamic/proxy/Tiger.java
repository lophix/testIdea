package pattern.dynamic.proxy;

/**
 * tiger class
 *
 * @author xuj
 * @version 1.0.1
 * @since 2017-03-23-18:09
 */
public class Tiger implements IAnimal {
    @Override
    public void eat() {
        System.out.println("tiger eat meat");
    }

    @Override
    public void active() {
        System.out.println("tiger run away");
    }
}
