package pattern.prototype;

/**
 * Created by Administrator on 2016/11/5.
 */
public class HumanProduceFactory {

    private static ProtoPerson person = new ProtoPerson();

    public static ProtoPerson createCommonPerson(){
        Head head = new Head();
        Face face = new Face();
        Body body = new Body();
        head.setFace(face);
        person.setHead(head);
        person.setBody(body);
        person.setName("Marry");
        return person;
    }
}
