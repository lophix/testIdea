package pattern.factory._abstract;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-11:18
 */
public class Truck {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model + " truck";
    }
}
