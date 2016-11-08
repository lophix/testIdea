package pattern.mediator;

/**
 * Created by Administrator on 2016/11/8.
 */
public class MediatorMain {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        HomeSeller homeSeller = new HomeSeller(mediator);
        HomeBuyer homeBuyer = new HomeBuyer(mediator);
        mediator.setHomeBuyer(homeBuyer);
        mediator.setHomeSeller(homeSeller);

        homeBuyer.sendMessage("Pay");
        homeSeller.sendMessage("Receive");
    }
}
