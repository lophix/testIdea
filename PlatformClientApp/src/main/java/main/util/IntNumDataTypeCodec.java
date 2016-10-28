package main.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class IntNumDataTypeCodec {
    private static final Logger LOGGER = LogManager.getLogger(IntNumDataTypeCodec.class);

    /**
     * 安装度转换数据
     */
    public static byte[] encodeIntDataToHexBytes(int data, int bytesLength) {
        byte[] resultBytes = new byte[bytesLength];

        byte[] encodeBytes ;
        try {
            encodeBytes = convertIntToBytes(data);

            if (encodeBytes.length >=2 ) {
                System.arraycopy(encodeBytes,0, resultBytes, 0, 2);
            } else {
                LOGGER.warn("convert failed {}", data);
            }
        } catch (Exception e) {
            LOGGER.error("data decoder exception  content {} ,length {} ,  {}", data,bytesLength ,e);
        }
        return resultBytes;
    }

    public static short  bytesToShortByLength(byte[] bytes , int length){
        short s = 0;
        byte[] result = new byte[length];
        if(bytes.length <= result.length){
            System.arraycopy(bytes,0,result,result.length-bytes.length,bytes.length);
            s = LittleEndianDataConvert.littleEndianBytesToShort(result);
        }
        return s;
    }

    /**
     *转换IP
     */
    public static byte[] encodeIPLongDataToHexBytes(long longData, int byteArrLength){
        byte[] resultBytes = new byte[byteArrLength];
        byte[] encodeBytes ;
        try {
            encodeBytes = ipLongToData(longData);
            if (encodeBytes.length >=byteArrLength) {
                System.arraycopy(encodeBytes,0, resultBytes, 0, byteArrLength);
            }
            for (int i = 0; i < encodeBytes.length / 2; i++) {
                byte temp = encodeBytes[i];
                resultBytes[i] = encodeBytes[resultBytes.length - 1 - i];
                encodeBytes[encodeBytes.length - 1 - i] = temp;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return resultBytes;
    }

    /**
     * 对int类型进行解包
     */
    public static int byteArrayToInt(byte[] b) {
        int iOutcome = 0;
        byte bLoop;
        for (int i = 0; i < 4; i++) {
            bLoop = b[i];
            iOutcome += (bLoop & 0xff) << (8 * i);
        }
        return iOutcome;
    }


    /**
     * 通过指定长度获取byte数组
     */
    private static byte[] convertIntToBytes(int in ,int byteArrayLength){
        byte[] result = new byte[byteArrayLength];
        byte[] bytes = convertIntToBytes(in);
        System.arraycopy(bytes,0,result,0,byteArrayLength);
        return result;
    }

    /**
     * int类型数字的封包算法
     */
    private static byte[] convertIntToBytes(int in){
        byte[] result = new byte[4];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte)(in >> i*8 & 0xFF);
        }
        return result;
    }

    /**
     * 长整型数据的读取
     */
    public static long convertBytesTolang(byte[] langBytes){
        long result = 0;
        result =((long) byteArrayToInt(langBytes) <<32)+(byteArrayToInt(langBytes)&0xFFFFFFFFL);
        return result;
    }




    /**
     * short的封包算法
     */
    public static byte[] convertShortToBytes(short shortInt){
        byte[] result = new byte[2];
        result[0] = (byte) (shortInt & 0xFF);
        result[1] = (byte) (shortInt >> 8 & 0xFF);
        return result;
    }
    /**
     * ip转换
     */
    public static byte[] ipLongToData(long number) {
        long temp = number;
        byte[] b = new byte[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Long(temp & 0xff).byteValue();//
            //将最低位保存在最低位
           temp = temp >> 8; // 向右移8位
        }
        return b;
    }

}
