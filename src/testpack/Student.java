package testpack;

/**
 * 学生类继承People
 *
 * @Authuor Administrator
 * @Create 2016-08-31-20:20
 */
public class Student extends People {
    private int sno;
    private int classno;
    private String teacher;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getClassno() {
        return classno;
    }

    public void setClassno(int classno) {
        this.classno = classno;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
