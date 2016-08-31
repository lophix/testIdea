package testpack;

/**
 * 老师类继承People类
 *
 * @Authuor Administrator
 * @Create 2016-08-31-20:36
 */
public class Teacher extends  People {
    private int tno;
    private String subname;

    public Teacher(){
        System.out.println("teacher constructor");
    }

    static {
        System.out.println("teacher static out");
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
}
