package pattern.state;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-12:56
 */
public class HealthState extends State {
    @Override
    public void state(States state) {
        if (state.getState() == 0){
            System.out.println("Health");
        }else{
            new BloodedState().state(state);
        }
    }
}
