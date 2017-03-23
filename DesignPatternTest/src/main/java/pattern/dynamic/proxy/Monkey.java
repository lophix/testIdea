package pattern.dynamic.proxy;

/**
 * monkey class
 *
 * @author xuj
 * @version 1.0.1
 * @since 2017-03-23-18:11
 */
public class Monkey implements IAnimal {
    @Override
    public void eat() {
        System.out.println("monkey eat banana");
    }

    @Override
    public void active() {
        System.out.println("monkey climb up a tree");
    }
}
