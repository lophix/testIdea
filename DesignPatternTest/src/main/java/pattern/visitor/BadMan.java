package pattern.visitor;

/**
 * @Authuor Administrator
 * @Create 2016-11-09-15:51
 */
public class BadMan extends Target {
    @Override
    public void beVisited(Visitor visitor) {
        visitor.visitBadMan(this);
    }
}
