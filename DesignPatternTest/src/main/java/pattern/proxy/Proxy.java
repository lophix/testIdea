package pattern.proxy;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-17:53
 */
public class Proxy implements IGivePresent {

    private Pursuer p;

    public Proxy(SchoolGirl schoolGirl){
        p = new Pursuer(schoolGirl);
    }

    @Override
    public void giveDolls() {
        p.giveDolls();
    }

    @Override
    public void giveChoco() {
        p.giveChoco();
    }

    @Override
    public void giveFlower() {
        p.giveFlower();
    }
}
