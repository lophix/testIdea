package pattern.composite;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-15:23
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("Leaf cannot add sub node");
    }

    @Override
    public void remove(Component c) {
        System.out.println("There are no sub node at Leaf");
    }

    @Override
    public void display(int depth) {
        String show = "";
        for (int i = 0; i < depth; i++) {
            show += "-";
        }
        show += name;
        System.out.println(show);
    }
}
