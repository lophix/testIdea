package pattern.responsibility.chain;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-17:28
 */
public class ResponsibilityChainMain {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        handlerA.addHandler(new ConcreteHandlerB()).addHandler(new ConcreteHandlerC()).addHandler(new Handler() {
            @Override
            public void handleRequest(String req) {
                System.out.println("This is a test");
            }
        });

        handlerA.handleRequest("bye");
        handlerA.handleRequest("hello");
        handlerA.handleRequest("what");
    }
}
