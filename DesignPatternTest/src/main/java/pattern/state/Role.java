package pattern.state;

/**
 * @Authuor Administrator
 * @Create 2016-11-07-13:10
 */
public class Role {
    private States states;
    private State state;

    public Role(){
        state = new HealthState();
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void state(){
        state.state(this.getStates());
    }
}
