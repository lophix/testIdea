package pattern.decorator;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-17:11
 */
public class Decorator extends Person {
    protected Person person;

    public Decorator(Person person){
        this.person = person;
    }

    @Override
    public void show() {
        person.show();
    }
}
