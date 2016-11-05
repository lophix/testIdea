package pattern.prototype;

/**
 * Created by Administrator on 2016/11/5.
 */
public class ProtoPerson implements Cloneable {
    private String name;
    private Head head;
    private Body body;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ProtoPerson clonePerson = null;
        clonePerson = (ProtoPerson) super.clone();
        clonePerson.setBody((Body) this.body.clone());
        clonePerson.setHead((Head) this.head.clone());
        return clonePerson;
    }
}
