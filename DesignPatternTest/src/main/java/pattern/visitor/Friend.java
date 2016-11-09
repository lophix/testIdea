package pattern.visitor;

/**
 * @Authuor Administrator
 * @Create 2016-11-09-15:57
 */
public class Friend extends Visitor {
    @Override
    public void visitGoodMan(Target target) {
        System.out.println("Become very good friend with " + target.getClass().getSimpleName());
    }

    @Override
    public void visitBadMan(Target target) {
        System.out.println("Become a stranger with " + target.getClass().getSimpleName());
    }
}
