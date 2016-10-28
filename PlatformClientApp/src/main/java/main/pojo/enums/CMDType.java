package main.pojo.enums;

import main.output.CMD106Processor;

/**
 * @Authuor Administrator
 * @Create 2016-10-28-13:44
 */
public enum CMDType {
    REGISTER_INFO(106, CMD106Processor.class);//充电转签到信息上报


    private  Integer resendTimes;
    private int cmdNum;
    private Class clazz;

    CMDType(int i, Class s,Integer resendTimes) {
        this.cmdNum = i;
        this.clazz = s;
        this.resendTimes = resendTimes;
    }

    CMDType(int i, Class s) {
        this.cmdNum = i;
        this.clazz = s;
    }

    CMDType(int cmdNum) {
        this.cmdNum = cmdNum;
    }

    public int getCmdNum() {
        return cmdNum;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setCmdNum(int cmdNum) {
        this.cmdNum = cmdNum;
    }

    public Integer getResendTimes() {
        return resendTimes;
    }

    public void setResendTimes(Integer resendTimes) {
        this.resendTimes = resendTimes;
    }

    public static CMDType getCMDTypeByCMDId(int cmdId) {
        CMDType resultCMD = null;
        for (CMDType cmdType : CMDType.values()) {
            if (cmdType.getCmdNum() == cmdId){
                resultCMD = cmdType;
                break;
            }
        }
        return resultCMD;
    }
}

