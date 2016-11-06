package pattern.builder;

/**
 * Created by Administrator on 2016/11/6.
 */
public class MaidRobotBuilder implements Builder {

    private Robot maidRobot = new Robot();

    @Override
    public void setHead() {
        maidRobot.setHead("beautiful girl");
    }

    @Override
    public void setBody() {
        maidRobot.setBody("sex");
    }

    @Override
    public void setHands() {
        maidRobot.setHands("thin");
    }

    @Override
    public void setFeet() {
        maidRobot.setFeet("soft");
    }

    @Override
    public Robot getRobot() {
        return maidRobot;
    }

}
