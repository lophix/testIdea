package pattern.mediator;

/**
 * Created by Administrator on 2016/11/8.
 */
public class HomeBuyer {

    private Mediator mediator;
    public HomeBuyer(Mediator mediator){
        this.mediator = mediator;
    }
    public void sendMessage(String msg){
        mediator.sendMessage(msg, this);
    }
    public void receive(String msg){
        System.out.println("Home buyer get message : " + msg);
    }
}
