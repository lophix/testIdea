package pattern.visitor;

/**
 * @Authuor Administrator
 * @Create 2016-11-09-15:56
 */
public class Assassin extends Visitor {
    @Override
    public void visitGoodMan(Target target) {
        System.out.println("Let the " + target.getClass().getSimpleName() + " off");
    }

    @Override
    public void visitBadMan(Target target) {
        System.out.println("Kill the " + target.getClass().getSimpleName());
    }
}
