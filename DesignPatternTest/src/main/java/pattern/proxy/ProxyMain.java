package pattern.proxy;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-17:57
 */
public class ProxyMain {
    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("masha");
        IGivePresent givePresent = new Proxy(schoolGirl);
        givePresent.giveFlower();
        givePresent.giveChoco();
        givePresent.giveDolls();
    }
}
