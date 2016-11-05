package pattern.factory.method;

/**
 * Created by Administrator on 2016/11/5.
 */
public class DragonFactory implements IFactory {
    public IMonster createMonster() {
        return new DragonMonster();
    }
}
