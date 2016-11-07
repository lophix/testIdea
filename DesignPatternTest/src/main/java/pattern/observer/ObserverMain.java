package pattern.observer;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-9:51
 */
public class ObserverMain {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observerA = new ConcreteObserverA();
        Observer observerB = new ConcreteObserverB();
        subject.attach(observerA);
        subject.attach(observerB);
        subject.change("Shopping festival");
    }
}
