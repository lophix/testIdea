package pattern.memento;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-14:30
 */
public class MementoMain {
    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("On");
        o.show();

        Memento memento = o.createMemento();
        Caretaker c = new Caretaker();
        c.setMemento(memento);

        o.setState("Off");
        o.show();

        o.rollBack(c.getMemento());
        o.show();
    }
}
