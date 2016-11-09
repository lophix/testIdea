package pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authuor Administrator
 * @Create 2016-11-09-16:02
 */
public class TargetStructure {
    private List<Target> targets = new ArrayList<>();

    public void attach(Target target){
        if (!targets.contains(target))
            targets.add(target);
    }

    public void dettach(Target target){
        if (targets.contains(target))
            targets.remove(target);
    }

    public void display(Visitor visitor){
        for (Target target : targets)
            target.beVisited(visitor);
    }
}
