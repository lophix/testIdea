package niotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO读文件
 *
 * @Authuor Administrator
 * @Create 2016-09-01-17:28
 */
public class Program {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("hello.txt");
            //获取管道
            FileChannel fc = fin.getChannel();
            //创建缓存区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //读取数据到缓存区
            fc.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                byte b = byteBuffer.get();
                System.out.print((char) b);
            }
            fin.close();
            fc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
