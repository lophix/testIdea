package pattern.responsibility.chain;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-17:19
 */
public class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String req) {
        if ("hello".equalsIgnoreCase(req))
            System.out.println(this.getClass().getSimpleName() + " : " + req);
        else
            next.handleRequest(req);
    }
}
