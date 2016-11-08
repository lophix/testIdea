package pattern.command;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-16:21
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }
}
