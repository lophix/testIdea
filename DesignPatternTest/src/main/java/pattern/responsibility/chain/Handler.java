package pattern.responsibility.chain;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-16:46
 */
public abstract class Handler {
    public Handler head, next;

    public Handler addHandler(Handler handler){
        Handler theNext = this.next;
        if (head == null)
            head = handler;
        if (theNext == null){
            this.next = handler;
            return head;
        }
        while(theNext.next != null ){
            theNext = theNext.next;
        }
        theNext.next = handler;
        return head;
    }

    public abstract void handleRequest(String req);
}
