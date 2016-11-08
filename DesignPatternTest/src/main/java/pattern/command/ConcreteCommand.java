package pattern.command;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-16:24
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
