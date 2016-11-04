package pattern.decorator;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-17:08
 */
public class Person {
    private String name;

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println(name);
    }
}
