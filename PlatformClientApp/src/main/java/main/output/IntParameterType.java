package main.output;

import main.pojo.enums.CMDType;

public enum IntParameterType {
    REGISTER_INFO("center_server_adress", 25, CMDType.REGISTER_INFO, 4);


    /**
     * 字段定义
     */
    private String fieldName;
    /**
     * 参数地址
     */
    private int fieldPosition;
    /**
     * 所属的CMD类型
     */
    private CMDType cmdType;

    /**
     * 字段名称
     */
    private int fieldLength;


    IntParameterType(String fieldName, int paramPosition, CMDType operateCommandCharsSend, int fieldLength) {
        this.fieldName = fieldName;
        this.fieldPosition = paramPosition;
        this.cmdType = operateCommandCharsSend;
        this.fieldLength = fieldLength;
    }

    public String getFieldName() {
        return fieldName;
    }


    public int getFieldPosition() {
        return fieldPosition;
    }


    public CMDType getCmdType() {
        return cmdType;
    }

    public int getFieldLength() {
        return fieldLength;
    }
}
