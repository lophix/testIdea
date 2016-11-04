package pattern.proxy;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-17:49
 */
public class Pursuer implements IGivePresent {

    public String name = "pursuer";

    private SchoolGirl schoolGirl;

    public Pursuer(SchoolGirl schoolGirl){
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveDolls() {
        System.out.println(name + " give dolls to " + schoolGirl.getName());
    }

    @Override
    public void giveChoco() {
        System.out.println(name + " give choco to " + schoolGirl.getName());
    }

    @Override
    public void giveFlower() {
        System.out.println(name + " give flower to " + schoolGirl.getName());
    }
}
