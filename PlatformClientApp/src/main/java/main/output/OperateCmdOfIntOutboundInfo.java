package main.output;


import main.util.X;

import java.util.List;

public class OperateCmdOfIntOutboundInfo extends PileInfo {
    /**
     * 命令的类型： 0 查询  ;1 设置
     */
    private byte commandType;
    /**
     * 命令的起始地址
     * 指向参数列表中的“命令地址栏“
     */
    private int cmdStartPosition;

    /**
     * 参数个数
     */
    private int cmdParameterNumbers;

    /**
     * 命令参数的总长度 字节
     */
    private int cmdLength;

    /**
     * 参数列表
     */
    private List<IntParameterBean> parameterList;

    public int getCmdParameterNumbers() {
        return cmdParameterNumbers;
    }

    public void setCmdParameterNumbers(int cmdParameterNumbers) {
        this.cmdParameterNumbers = cmdParameterNumbers;
    }

    public byte getCommandType() {
        return commandType;
    }

    public void setCommandType(byte commandType) {
        this.commandType = commandType;
    }

    public int getCmdStartPosition() {
        return cmdStartPosition;
    }

    public void setCmdStartPosition(int cmdStartPosition) {
        this.cmdStartPosition = cmdStartPosition;
    }

    public int getCmdLength() {
        return cmdLength;
    }

    public void setCmdLength(int cmdLength) {
        this.cmdLength = cmdLength;
    }

    public List<IntParameterBean> getParameterList() {
        return parameterList;
    }

    /**
     * 将IntParameter数组添加到参数列表中
     * @param ps 参数数组
     */
    public void addParameters(IntParameterBean... ps) {
        this.parameterList = this.getParameterList() == null ? X.createArrayList() : this.getParameterList();
        for (IntParameterBean p : ps) {
            getParameterList().add(p);
        }
    }

    public void setParameterList(List<IntParameterBean> parameterList) {
        this.parameterList = parameterList;
    }

    /**
     * 获取多有字段的长度
     */
    public int getParameterListLength() {
        int length = 0;
        for (int i = 0; i < getParameterList().size(); i++) {
            length += getParameterList().get(i).getPrmType().getFieldLength();
        }
        return length;
    }
}
