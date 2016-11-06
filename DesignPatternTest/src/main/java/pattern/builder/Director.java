package pattern.builder;

/**
 * Created by Administrator on 2016/11/6.
 */
public class Director {

    private Builder builder;

    public void construct(Builder builder){
        this.builder = builder;
        builder.setHead();
        builder.setBody();
        builder.setFeet();
        builder.setHands();
    }
}
