package main.util;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BytePartUtil {
    private static Logger logger = LogManager.getLogger(BytePartUtil.class);
    /**
     * 根据字节数及要截取对应长度的整型数组值截取出多个数组
     * @param bytes
     * @param parts
     * @return
     */
    public static List<byte[]> partBytes(byte[] bytes,int[] parts){
        List<byte[]> listBytes = new ArrayList<byte[]>();
        try{
            if(bytes!=null&&bytes.length>0){
                if(parts!=null&&parts.length>0){
                    //起始字节
                    int startIndex = 0;
                    for(int partLength : parts){
                        //需要读取的某一段的字节数组
                        byte[] partBytes = new byte[partLength];
                        for (int i = 0; i < partLength; i++) {
                            partBytes[i] = bytes[startIndex+i];
                        }
                        startIndex = startIndex+partLength;
                        listBytes.add(partBytes);
                    }
                }
            }
        }catch(Exception e){
            e.fillInStackTrace();
            logger.error("error when split byte array");
        }
        return listBytes;
    }
   /* public static List<byte[]> partBytes(byte[] bytes,int[] parts){
        List<byte[]> listBytes = new ArrayList<byte[]>();
        ByteBuf buf = null;
        try{
            if(bytes!=null&&bytes.length>0){
                buf = Unpooled.copiedBuffer(bytes);
                if(parts!=null&&parts.length>0){
                    for(int partLength : parts){
                        byte[] partBytes = new byte[partLength];
                        for (int i = 0; i < partBytes.length; i++) {
                            partBytes[i] = buf.readByte();
                        }
                        listBytes.add(partBytes);
                    }
                }
                buf.clear();
            }
        }catch(Exception e){
            buf.clear();
            e.fillInStackTrace();
            logger.error("error when split byte array");
            throw  new RuntimeException(e.getMessage());
        }
        return listBytes;
    }*/


    public static long readBufferLength(InputStream inputStream){
        byte[] buffer = new byte[1];
        long temp = 0 ;
        int numRead = 0;
        do {
            try {
                numRead = inputStream.read(buffer);
                if (numRead > 0) {
                    temp += buffer.length;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }while (numRead!=-1);
        return temp;
    }

    /*public static void inputStreamToFile(InputStream ins) {
        try {
            File file = new File(HttpApiProperties.getParameter(APIConst.TCP_FILE_DOWNLOAD_PATH.getInfo()));
            if(file.exists()){
                file.delete();
            }
            OutputStream os = new FileOutputStream(new File(HttpApiProperties.getParameter(APIConst.TCP_FILE_DOWNLOAD_PATH.getInfo())));
            int bytesRead = 0;
            int size = Integer.parseInt(HttpApiProperties.getParameter(APIConst.TCP_FILE_DOWNLOAD_SIZE.getInfo()));
            byte[] buffer = new byte[size];
            while ((bytesRead = ins.read(buffer, 0, size)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static String bytesToVersionString(byte[] bytes){
        String version = StringUtils.EMPTY;
        for(int i = 0; i < bytes.length; i ++){
            int intI = bytes[i]&0xff;
            if(i<bytes.length-1){
                if(intI>0){
                    version+=intI+".";
                }
            }else{
                version+=intI;
            }
        }
        return version;
    }

}
