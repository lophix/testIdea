package pattern.memento;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-14:13
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void rollBack(Memento memento){
        this.state = memento.getState();
    }

    public void show(){
        System.out.println("The state is " + state);
    }
}
