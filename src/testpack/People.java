package testpack;

/**
 * Created by Administrator on 2016/8/31.
 */
public class People {
    private String name;
    private String sex;
    private int age;

    public People(){
        System.out.println("people constructor");
    }

    static{
        System.out.println("people static out");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getName() + "\t" + this.getSex() + "\t" + this.getAge() ;
    }
}
