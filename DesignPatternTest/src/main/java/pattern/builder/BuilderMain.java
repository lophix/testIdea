package pattern.builder;

/**
 * Created by Administrator on 2016/11/6.
 */
public class BuilderMain {
    public static void main(String[] args) {
        Builder armorRobotBuilder = new ArmorRobotBuilder();
        Builder maidRobotBuilder = new MaidRobotBuilder();
        Director d = new Director();
        System.out.println(armorRobotBuilder.getRobot().toString());
        System.out.println(maidRobotBuilder.getRobot().toString());
        d.construct(armorRobotBuilder);
        d.construct(maidRobotBuilder);
        System.out.println(armorRobotBuilder.getRobot().toString());
        System.out.println(maidRobotBuilder.getRobot().toString());
    }
}
