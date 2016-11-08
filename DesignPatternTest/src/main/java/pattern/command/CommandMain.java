package pattern.command;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-16:29
 */
public class CommandMain {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command c = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(c);

        invoker.executeCommand();
    }
}
