package pattern.mediator;

/**
 * Created by Administrator on 2016/11/8.
 */
public class HomeSeller {
    private Mediator mediator ;
    public HomeSeller(Mediator mediator){
        this.mediator = mediator;
    }
    public void sendMessage(String msg){
        mediator.sendMessage(msg, this);
    }
    public void receive(String msg){
        System.out.println("Home seller get message : " + msg);
    }
}
