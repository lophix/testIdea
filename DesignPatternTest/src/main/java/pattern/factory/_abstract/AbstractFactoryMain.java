package pattern.factory._abstract;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-11:26
 */
public class AbstractFactoryMain {
    public static void main(String[] args) {
        IFactory jieFangFactory = new JieFangFactory();
        System.out.println(jieFangFactory.createCar());
        System.out.println(jieFangFactory.createBus());
        System.out.println(jieFangFactory.createTruck());
        IFactory hongqiFactory = new HongQiFactory();
        System.out.println(hongqiFactory.createCar());
        System.out.println(hongqiFactory.createBus());
        System.out.println(hongqiFactory.createTruck());
    }
}
