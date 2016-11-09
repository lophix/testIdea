package pattern.builder;

/**
 * Created by Administrator on 2016/11/6.
 */
public class Director {

    public void construct(Builder builder){
        builder.setHead();
        builder.setBody();
        builder.setFeet();
        builder.setHands();
    }
}
