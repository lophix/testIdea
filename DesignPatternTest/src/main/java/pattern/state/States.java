package pattern.state;

/**
 * Created by Administrator on 2016/11/7.
 */
public enum States {
    health(0),blooded(1),poisoned(2);

    private int state;

    States(int state){
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
