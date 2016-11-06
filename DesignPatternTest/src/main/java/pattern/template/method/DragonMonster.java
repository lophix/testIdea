package pattern.template.method;

/**
 * Created by Administrator on 2016/11/6.
 */
public class DragonMonster extends Monster {

    @Override
    public String monster() {
        return "The dragon";
    }

    @Override
    public void special() {
        System.out.println("The dragon fired");
    }
}
