package pattern.template.method;

/**
 * Created by Administrator on 2016/11/6.
 */
public class WolfMonster extends Monster {
    @Override
    public String monster() {
        return "The wolf";
    }

    @Override
    public void special() {
        System.out.println("The wolf howled");
    }
}
