package pattern.responsibility.chain;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-17:31
 */
public class ConcreteHandlerC extends Handler {
    @Override
    public void handleRequest(String req) {
        if ("what".equalsIgnoreCase(req))
            System.out.println(this.getClass().getSimpleName() + " : " + req);
        else
            next.handleRequest(req);
    }
}
