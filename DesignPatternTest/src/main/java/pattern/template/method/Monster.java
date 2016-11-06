package pattern.template.method;

/**
 * Created by Administrator on 2016/11/6.
 */
public abstract class Monster {
    public abstract String monster();
    public void acttack(){
        System.out.println(monster() + " attacked");
    }
    public void defense(){
        System.out.println(monster() + " defensed");
    }
    public abstract void special();
}
