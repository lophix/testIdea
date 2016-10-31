package main.pojo;

/**
 * @Authuor Administrator
 * @Create 2016-10-31-17:57
 */
public class DataPackageBean {
    private int startDomain;
    private int lengthDomain;
    private int versionDomain;
    private int serialDomain;
    private int commandDomain;
    private byte[] dataDomain;
    private int verifyDomain;

    public int getStartDomain() {
        return startDomain;
    }

    public void setStartDomain(int startDomain) {
        this.startDomain = startDomain;
    }

    public int getLengthDomain() {
        return lengthDomain;
    }

    public void setLengthDomain(int lengthDomain) {
        this.lengthDomain = lengthDomain;
    }

    public int getVersionDomain() {
        return versionDomain;
    }

    public void setVersionDomain(int versionDomain) {
        this.versionDomain = versionDomain;
    }

    public int getSerialDomain() {
        return serialDomain;
    }

    public void setSerialDomain(int serialDomain) {
        this.serialDomain = serialDomain;
    }

    public int getCommandDomain() {
        return commandDomain;
    }

    public void setCommandDomain(int commandDomain) {
        this.commandDomain = commandDomain;
    }

    public byte[] getDataDomain() {
        return dataDomain;
    }

    public void setDataDomain(byte[] dataDomain) {
        this.dataDomain = dataDomain;
    }

    public int getVerifyDomain() {
        return verifyDomain;
    }

    public void setVerifyDomain(int verifyDomain) {
        this.verifyDomain = verifyDomain;
    }
}
