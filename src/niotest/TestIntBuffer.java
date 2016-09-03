package niotest;

import java.nio.IntBuffer;

/**
 * 测试IntBuffer
 *
 * @Authuor Administrator
 * @Create 2016-09-01-17:00
 */
public class TestIntBuffer {
    public static void main(String[] args){
        IntBuffer intBuffer = IntBuffer.allocate(8);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            int j = 2*(i+1);
            intBuffer.put(j);
        }

        intBuffer.flip();

        while(intBuffer.hasRemaining()){
            int j = intBuffer.get();
            System.out.print(j + "\t");
        }

    }
}
