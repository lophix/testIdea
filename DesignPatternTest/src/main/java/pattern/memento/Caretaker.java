package pattern.memento;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-14:14
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
