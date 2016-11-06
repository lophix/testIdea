package pattern.builder;

/**
 * Created by Administrator on 2016/11/6.
 */
public interface Builder {
    void setHead();
    void setBody();
    void setHands();
    void setFeet();
    Robot getRobot();
}
