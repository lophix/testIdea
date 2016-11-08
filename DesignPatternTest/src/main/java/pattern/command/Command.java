package pattern.command;

/**
 * Created by Administrator on 2016/11/8.
 */
public abstract class Command {
    protected Receiver receiver;
    public Command(Receiver receiver){
        this.receiver = receiver;
    }
    public abstract void execute();
}
