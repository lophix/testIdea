package pattern.observer;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-9:46
 */
public class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("The subject is : " + state);
        notifyObservers(state);
    }
}
