package pattern.factory.method;

/**
 * Created by Administrator on 2016/11/5.
 */
public class WolfMonster implements IMonster {
    public void attack() {
        System.out.println("WolfMonster attacked");
    }

    public void defense() {
        System.out.println("WolfMonster defensed");
    }
}
