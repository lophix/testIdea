package pattern.memento;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-14:14
 */
public class Memento {
    private String state;
    public Memento(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
