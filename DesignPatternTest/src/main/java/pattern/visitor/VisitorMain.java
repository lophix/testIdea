package pattern.visitor;

/**
 * @Authuor Administrator
 * @Create 2016-11-09-16:05
 */
public class VisitorMain {
    public static void main(String[] args) {
        Target good = new GoodMan();
        Target bad = new BadMan();
        TargetStructure structure = new TargetStructure();
        structure.attach(good);
        structure.attach(bad);

        structure.display(new Assassin());
        structure.display(new Friend());
    }
}
