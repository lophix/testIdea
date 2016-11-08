package pattern.responsibility.chain;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-17:26
 */
public class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(String req) {
        if ("bye".equalsIgnoreCase(req))
            System.out.println(this.getClass().getSimpleName() + " : " + req);
        else
            next.handleRequest(req);
    }
}
