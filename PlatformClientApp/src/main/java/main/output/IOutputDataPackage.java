package main.output;

import main.pojo.enums.CMDType;

/**
 * Created by pingxin on 2015/12/23.
 */
public interface IOutputDataPackage {
    /**
     * 输出数据的修改器
     * 将输入的Object各个字段的值按照指定长度转换为byte数组
     * @param cmdType
     * @param value
     */
    public abstract byte[] outputDataRectify(CMDType cmdType, Object value);
}
