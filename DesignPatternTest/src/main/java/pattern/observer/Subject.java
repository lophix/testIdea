package pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-9:42
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void dettach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(String newState){
        for (Observer o : observers){
            o.update(newState);
        }
    }
}
