package pattern.factory.method;

/**
 * Created by Administrator on 2016/11/5.
 */
public class DragonMonster implements IMonster{
    public void attack() {
        System.out.println("DragonMonster attacked");
    }

    public void defense() {
        System.out.println("DragonMonster defensed");
    }
}
