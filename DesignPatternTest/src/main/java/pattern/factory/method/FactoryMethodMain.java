package pattern.factory.method;

/**
 * Created by Administrator on 2016/11/5.
 */
public class FactoryMethodMain {
    public static void main(String[] args) {
        IFactory factory = new DragonFactory();
        IMonster monster = factory.createMonster();
        monster.attack();
        monster.defense();
        System.out.println("*********************************");
        factory = new WolfFactory();
        monster = factory.createMonster();
        monster.attack();
        monster.defense();
    }
}
