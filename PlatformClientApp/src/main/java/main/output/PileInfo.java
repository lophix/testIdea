package main.output;

public class PileInfo {
    private short userID;
    private short CommandsNo;
    private String pileCode = "";
    /**
     * 充电桩的类型
     * AC
     * DC
     */
    private byte pileType;


    /**
     * 充电枪的口
     * 只有一个枪口的电桩默认是0
     */
    private byte gunCode;

    /**
     * 充电枪的口
     * 只有一个枪口的电桩默认是0
     */
    public byte getGunCode() {
        return gunCode;
    }

    /**
     * 充电枪的口
     * 只有一个枪口的电桩默认是0
     */
    public void setGunCode(byte gunCode) {
        this.gunCode = gunCode;
    }

    /**
     * 桩的工作状态
     */
    private byte gun_pile_work_status;

    /**
     * 用户ID
     */
    public short getUserID() {
        return userID;
    }

    /**
     * 用户ID
     */
    public void setUserID(short userID) {
        this.userID = userID;
    }

    /**
     * 指令序号
     */
    public short getCommandsNo() {
        return CommandsNo;
    }

    /**
     * 指令序号
     */
    public void setCommandsNo(short commandsNo) {
        CommandsNo = commandsNo;
    }

    /**
     * 电桩编码
     */
    public String getPileCode() {
        return pileCode;
    }

    /**
     * 电桩编码
     */
    public void setPileCode(String pileCode) {
        this.pileCode = pileCode;
    }

    /**
     * 电桩类型
     */
    public byte getPileType() {
        return pileType;
    }

    /**
     * 电桩类型
     */
    public void setPileType(byte pileType) {
        this.pileType = pileType;
    }

    /**
     * 桩的工作状态
     */
    public byte getGun_pile_work_status() {
        return gun_pile_work_status;
    }

    /**
     * 桩的工作状态
     */
    public void setGun_pile_work_status(byte gun_pile_work_status) {
        this.gun_pile_work_status = gun_pile_work_status;
    }
}
