package pattern.state;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-12:57
 */
public class BloodedState extends State {
    @Override
    public void state(States state) {
        if (state.getState() == 1){
            System.out.println("Blooded");
        }else{
            new PoisonedState().state(state);
        }
    }
}
