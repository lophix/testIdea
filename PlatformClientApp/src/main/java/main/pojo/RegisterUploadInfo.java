package main.pojo;

import java.io.Serializable;
import java.util.Date;

public class RegisterUploadInfo extends OperateCmdOfIntOutboundInfo implements Serializable {
    /**
     * 充电桩的版本号
     */
    private String version;
    /**
     * 充电桩项目类型
     */
    private String pileProjectType;

    /**
     * 启动次数
     */
    private int startTimes;

    /**
     * 数据上传模式
     */
    private byte uploadMode;

    /**
     * 签到时间间隔
     */
    private short intervalTime;


    /**
     * 枪的个数
     */
    private byte gunNum;

    /**
     * 充电桩的心跳上传周期
     */
    private byte intervalHeartbeat;

    /**
     * 心跳包检测超时次数
     */
    private short heartbeatCheckTimes;

    /**
     * 充电记录数量
     */
    private int pileRecordNum;

    /**
     * 当前充电桩的系统时间
     */
    private Date pileCurTimes;

    /**
     * 最近一次启动时间
     */
    private Date LastStartTime;

    /**
     * 最近一次充电时间
     */
    private Date lastChargingTime;

    /**
     * 签到密码
     */
    private String registerPassword;

    public int[] infoBinaryPerFiledLength = new int[]{2, 2, 32, 1, 4, 2, 4, 1, 2, 1, 1, 1, 1, 4, 8, 8, 8, 8,32};
    /**
     * 桩的MAC地址货号IMEI码
     */
    private String pileLocalIMEIOrMAC ="";

    public int[] getInfoBinaryPerFiledLength() {
        return infoBinaryPerFiledLength;
    }

    public String getPileProjectType() {
        return pileProjectType;
    }

    public void setPileProjectType(String pileProjectType) {
        this.pileProjectType = pileProjectType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(int startTimes) {
        this.startTimes = startTimes;
    }

    public byte getUploadMode() {
        return uploadMode;
    }

    public void setUploadMode(byte uploadMode) {
        this.uploadMode = uploadMode;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }

    /**
     * 签到时间间隔
     */
    public int getIntervalTime() {
        return intervalTime;
    }

    /**
     * 签到时间间隔
     */
    public void setIntervalTime(short intervalTime) {
        this.intervalTime = intervalTime;
    }

    public byte getGunNum() {
        return gunNum;
    }

    public void setGunNum(byte gunNum) {
        this.gunNum = gunNum;
    }

    public byte getIntervalHeartbeat() {
        return intervalHeartbeat;
    }

    public void setIntervalHeartbeat(byte intervalHeartbeat) {
        this.intervalHeartbeat = intervalHeartbeat;
    }

    public short getHeartbeatCheckTimes() {
        return heartbeatCheckTimes;
    }

    public void setHeartbeatCheckTimes(short heartbeatCheckTimes) {
        this.heartbeatCheckTimes = heartbeatCheckTimes;
    }

    public int getPileRecordNum() {
        return pileRecordNum;
    }

    /**
     * 充电记录数量
     */
    public void setPileRecordNum(int pileRecordNum) {
        this.pileRecordNum = pileRecordNum;
    }

    public Date getPileCurTimes() {
        return pileCurTimes;
    }

    public java.sql.Timestamp getPileCurTimeToSqlDateTime() {
        return getPileCurTimes() == null ? null : new java.sql.Timestamp(getPileCurTimes().getTime());
    }

    public void setPileCurTimes(Date pileCurTimes) {
        this.pileCurTimes = pileCurTimes;
    }

    public Date getLastStartTime() {
        return LastStartTime;
    }

    public void setLastStartTime(Date lastStartTime) {
        LastStartTime = lastStartTime;
    }

    public java.sql.Timestamp getLastStartTimeToSqlDate() {
        return getLastStartTime() == null ? null : new java.sql.Timestamp(getLastStartTime().getTime());
    }

    public Date getLastChargingTime() {
        return lastChargingTime;
    }

    public void setLastChargingTime(Date lastChargingTime) {
        this.lastChargingTime = lastChargingTime;
    }

    public java.sql.Timestamp getLastChargingTimeToSqlDate() {
        return getLastChargingTime() == null ? null : new java.sql.Timestamp(getLastChargingTime().getTime());
    }




    @Override
    public String toString() {
        return "RegisterUploadInfo{" +
                "version=" + version +
                ", pileProjectType=" + pileProjectType +
                ", startTimes=" + startTimes +
                ", uploadMode=" + uploadMode +
                ", intervalTime=" + intervalTime +
                ", gunNum=" + gunNum +
                ", intervalHeartbeat=" + intervalHeartbeat +
                ", heartbeatCheckTimes=" + heartbeatCheckTimes +
                ", pileRecordNum=" + pileRecordNum +
                ", pileCurTimes=" + pileCurTimes +
                ", LastStartTime=" + LastStartTime +
                ", lastChargingTime=" + lastChargingTime +
                '}';
    }


    public void setPileLocalIMEIOrMAC(String pileLocalIMEIOrMAC) {
        this.pileLocalIMEIOrMAC = pileLocalIMEIOrMAC;
    }

    public String getPileLocalIMEIOrMAC() {
        return pileLocalIMEIOrMAC;
    }
}
