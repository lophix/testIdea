package main.pojo;

import main.output.PileInfo;
import main.pojo.enums.VendorID;

import java.util.Map;

/**
 * @Authuor Administrator
 * @Create 2016-10-28-12:50
 */
public class ReturnBean {
    private Map<Integer,Object> returnMap;

    private VendorID vendorID;

    /**
     * 桩的信息
     */
    private PileInfo pileInfo;

    /**
     * 是否需要返回
     */
    private boolean isNeetResponses = true;

    /**
     * 用来设置序列号域，默认0x1
     * modify by qudong-2016-02-29
     * @return
     */
    private byte serialId=0x1;

    public Map<Integer, Object> getReturnMap() {
        return returnMap;
    }

    public void setReturnMap(Map<Integer, Object> returnMap) {
        this.returnMap = returnMap;
    }

    public VendorID getVendorID() {
        return vendorID;
    }

    public void setVendorID(VendorID vendorID) {
        this.vendorID = vendorID;
    }

    /**
     * 是否需要返回 默认为true
     */
    public boolean isNeetResponses() {
        return isNeetResponses;
    }

    /**
     * 是否需要返回 ，默认为true
     */
    public void setNeetResponses(boolean neetResponses) {
        isNeetResponses = neetResponses;
    }

    public PileInfo getPileInfo() {
        return pileInfo;
    }

    public void setPileInfo(PileInfo pileInfo) {
        this.pileInfo = pileInfo;
    }

    public byte getSerialId() {
        return serialId;
    }

    public void setSerialId(byte serialId) {
        this.serialId = serialId;
    }
}
