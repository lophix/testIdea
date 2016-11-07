package pattern.composite;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-15:37
 */
public class CompositeMain {
    public static void main(String[] args) {
        Component root = new Composite("root");

        Component nodeA = new Composite("node A");
        Component leafX = new Leaf("leaf X");
        Component leafY = new Leaf("leaf Y");
        nodeA.add(leafX);
        nodeA.add(leafY);

        Component nodeB = new Composite("node B");
        Component leaf1 = new Leaf("leaf 1");
        Component leaf2 = new Leaf("leaf 2");
        nodeB.add(leaf1);
        nodeB.add(leaf2);

        root.add(nodeA);
        root.add(nodeB);

        root.display(1);
    }
}
