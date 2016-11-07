package pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-15:22
 */
public class Composite extends Component {
    private List<Component> components = new ArrayList<>();
    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        if (!components.contains(c))
            components.add(c);
    }

    @Override
    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public void display(int depth) {
        String show = "";
        for (int i = 0; i < depth; i++) {
            show += "-";
        }
        show += name;
        System.out.println(show);
        for (Component c : components){
            c.display(depth + 2);
        }
    }
}
