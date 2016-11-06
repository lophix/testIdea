package pattern.builder;

/**
 * Created by Administrator on 2016/11/6.
 */
public class ArmorRobotBuilder implements Builder {

    private Robot armorRobot = new Robot();

    @Override
    public void setHead() {
        armorRobot.setHead("armor head");
    }

    @Override
    public void setBody() {
        armorRobot.setBody("armor body");
    }

    @Override
    public void setHands() {
        armorRobot.setHands("big");
    }

    @Override
    public void setFeet() {
        armorRobot.setFeet("fat");
    }

    @Override
    public Robot getRobot() {
        return armorRobot;
    }
}
