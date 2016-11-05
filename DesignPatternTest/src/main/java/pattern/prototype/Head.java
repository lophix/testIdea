package pattern.prototype;

/**
 * Created by Administrator on 2016/11/5.
 */
public class Head implements Cloneable {
    private Face face;

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Head head = null;
        head = (Head) super.clone();
        head.setFace((Face) this.face.clone());
        return head;
    }
}
