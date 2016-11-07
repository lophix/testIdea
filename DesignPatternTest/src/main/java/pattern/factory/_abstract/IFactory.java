package pattern.factory._abstract;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-11:14
 */
public interface IFactory {
    Car createCar();
    Bus createBus();
    Truck createTruck();
}
