package pattern.state;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-13:06
 */
public class StateMain {
    public static void main(String[] args) {
        Role role = new Role();
        role.setStates(States.health);
        role.state();
        role.setStates(States.blooded);
        role.state();
        role.setStates(States.poisoned);
        role.state();
    }
}
