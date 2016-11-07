package pattern.state;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-13:03
 */
public class PoisonedState extends State {
    @Override
    public void state(States state) {
        if (state.getState() == 2){
            System.out.println("Poisoned");
        }else{
            new HealthState().state(state);
        }
    }
}
