package pattern.factory._abstract;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-11:17
 */
public class HongQiFactory implements IFactory {
    @Override
    public Car createCar() {
        Car car = new Car();
        car.setModel("Hong Qi Suv");
        return car;
    }

    @Override
    public Bus createBus() {
        Bus bus = new Bus();
        bus.setModel("Hong Qi journey");
        return bus;
    }

    @Override
    public Truck createTruck() {
        Truck truck = new Truck();
        truck.setModel("Hong Qi farm");
        return truck;
    }
}
