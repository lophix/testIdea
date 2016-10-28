package main.pojo;


import main.pojo.enums.VendorID;
import main.util.IntNumDataTypeCodec;

public class DataPackageInfo {


    /**
     * 起始域，两个字节长度
     */
    public static byte[] getStartDomain() {
        return new byte[]{(byte) 0xAA, (byte) 0xF5};
    }

    public static byte[] getStartDomainFeiHong() {
        return new byte[]{(byte) 0xAA, (byte) 0xFA};
    }

    public static byte[] getStartDomainBaSiBa() {
        return new byte[]{(byte) 0xAA, (byte) 0xF6};
    }
    public static byte[] getStartDomainYingFeiYuan() {
        return new byte[]{(byte) 0xAA, (byte) 0xF7};
    }
    public static byte[] getStartDomainHangJia() {
        return new byte[]{(byte) 0xAA, (byte) 0xF8};
    }
    public static byte[] getStartDomainRoBinSon() {
        return new byte[]{(byte) 0xAA, (byte) 0xF9};
    }
    public static byte[] getStartDomainYiPuLeShi() {
        return new byte[]{(byte) 0xAA, (byte) 0xFB};
    }
    public static byte[] getStartDomainKeHua() {
        return new byte[]{(byte) 0xAA, (byte) 0xFC};
    }
    public static byte[] getStartDomainZhuiRi() {
        return new byte[]{(byte) 0xAA, (byte) 0xFD};
    }


    /**
     * 版本域
     */
    public static byte[] getVersionDomain() {
        byte[] bytes = new byte[]{(byte) 0X10};
        return bytes;
    }

    /**
     * 构建长度域
     *
     * @param dataLength 数据长度
     * @return 16进制的byte数组
     */
    public static byte[] buildLengthDomain(int dataLength) {
        return IntNumDataTypeCodec.encodeIntDataToHexBytes(dataLength, 2);
    }

    /**
     * 构建序号域
     */
    public static byte[] buildIndexDomain(int index) {
        return new byte[]{(byte) index};
    }

    /**
     * 命令代码域
     */
    public static byte[] buildCMDDomain(int CMD) {
        return IntNumDataTypeCodec.encodeIntDataToHexBytes(CMD, 2);
    }

    public static byte[] buildCheckDataDomain(int checkData) {
        return new byte[]{(byte) checkData};
    }


    /**
     * 填充数组到固定长度
     *
     * @param bytes
     * @param neetLength
     * @return
     */
    public static byte[] suppleArrays(byte[] bytes, int neetLength) {
        byte[] result = new byte[neetLength];
        if (bytes.length < result.length) {
            for (int i = 0; i < result.length; i++) {

            }
        }
        return result;
    }

    public static byte[] getStartDomainByVenderId(VendorID venderID) {
        if (venderID ==null){
            return new byte[]{0,0};
        }
        byte[] result = null;
        switch (venderID) {
            case FEIHONG:
                result = getStartDomainFeiHong();
                break;
            default:
                System.out.println("VenderID is invaild ");
                result = new byte[]{0,0};
        }
        return result;
    }
}
