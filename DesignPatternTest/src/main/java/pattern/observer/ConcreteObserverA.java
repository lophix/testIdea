package pattern.observer;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-9:49
 */
public class ConcreteObserverA implements Observer {

    private String observerState;

    @Override
    public void update(String newState) {
        observerState = newState;
        System.out.println("Observer A : The observer state is " + observerState);
    }
}
