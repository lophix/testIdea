package pattern.factory._abstract;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-11:16
 */
public class JieFangFactory implements IFactory {

    @Override
    public Car createCar() {
        Car car = new Car();
        car.setModel("Jie Fang Suv");
        return car;
    }

    @Override
    public Bus createBus() {
        Bus bus = new Bus();
        bus.setModel("Jie Fang journey");
        return bus;
    }

    @Override
    public Truck createTruck() {
        Truck truck = new Truck();
        truck.setModel("Jie Fang farm");
        return truck;
    }
}
