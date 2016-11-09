package pattern.visitor;

/**
 * @Authuor Administrator
 * @Create 2016-11-09-15:47
 */
public abstract class Visitor {
    public abstract void visitGoodMan(Target target);
    public abstract void visitBadMan(Target target);
}
