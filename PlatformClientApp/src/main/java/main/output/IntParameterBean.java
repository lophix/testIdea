package main.output;

/**
 * Created by pingxin on 2016/1/2.
 */
public class IntParameterBean {
    /**
     * 参数的值
     */
    private long value;
    /**
     * 参数的属性
     * 字段地址 字段定义名 参数所属的CMD 字段的长度
     */
    private IntParameterType prmType;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public IntParameterType getPrmType() {
        return prmType;
    }

    public void setPrmType(IntParameterType prmType) {
        this.prmType = prmType;
    }
}
