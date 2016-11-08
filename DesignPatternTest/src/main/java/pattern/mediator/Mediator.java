package pattern.mediator;

/**
 * Created by Administrator on 2016/11/8.
 */
public class Mediator {
    private HomeBuyer homeBuyer;
    private HomeSeller homeSeller;

    public HomeBuyer getHomeBuyer() {
        return homeBuyer;
    }

    public void setHomeBuyer(HomeBuyer homeBuyer) {
        this.homeBuyer = homeBuyer;
    }

    public HomeSeller getHomeSeller() {
        return homeSeller;
    }

    public void setHomeSeller(HomeSeller homeSeller) {
        this.homeSeller = homeSeller;
    }

    public void sendMessage(String msg, HomeBuyer homeBuyer){
        homeSeller.receive(msg);
    }

    public void sendMessage(String msg, HomeSeller homeSeller){
        homeBuyer.receive(msg);
    }
}
