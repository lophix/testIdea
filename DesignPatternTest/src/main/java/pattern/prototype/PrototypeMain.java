package pattern.prototype;

/**
 * Created by Administrator on 2016/11/5.
 */
public class PrototypeMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoPerson protoPerson = HumanProduceFactory.createCommonPerson();
        ProtoPerson clonePerson1 = (ProtoPerson) protoPerson.clone();
        ProtoPerson clonePerson2 = (ProtoPerson) protoPerson.clone();
        System.out.println("proto : " + protoPerson.getName() + "\thead : " + protoPerson.getHead()
                + "\tface : " + protoPerson.getHead().getFace() + "\tbody : " + protoPerson.getBody());
        System.out.println("proto : " + clonePerson1.getName() + "\thead : " + clonePerson1.getHead()
                + "\tface : " + clonePerson1.getHead().getFace() + "\tbody : " + clonePerson1.getBody());
        System.out.println("proto : " + clonePerson2.getName() + "\thead : " + clonePerson2.getHead()
                + "\tface : " + clonePerson2.getHead().getFace() + "\tbody : " + clonePerson2.getBody());
    }
}
