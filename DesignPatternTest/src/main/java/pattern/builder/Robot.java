package pattern.builder;

/**
 * Created by Administrator on 2016/11/6.
 */
public class Robot {
    private String head;
    private String body;
    private String hands;
    private String feet;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHands() {
        return hands;
    }

    public void setHands(String hands) {
        this.hands = hands;
    }

    public String getFeet() {
        return feet;
    }

    public void setFeet(String feet) {
        this.feet = feet;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("head : ");
        str.append(head);
        str.append(" body : ");
        str.append(body);
        str.append(" hands : ");
        str.append(hands);
        str.append(" feet : ");
        str.append(feet);
        return str.toString();
    }
}
