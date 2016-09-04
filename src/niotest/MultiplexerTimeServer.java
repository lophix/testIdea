package niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用处理类
 * @Authuor Administrator
 * @Create 2016-09-03-15:03
 */
public class MultiplexerTimeServer implements Runnable {
    private Selector selector;
    private ServerSocketChannel servChannel;
    private volatile boolean stop;

    /**
     * c初始化多路复用器，绑定监听端口
     * @param port
     */
    public MultiplexerTimeServer(int port) {
        try {
            selector = Selector.open();
            servChannel = ServerSocketChannel.open();
            servChannel.configureBlocking(false);
            servChannel.bind(new InetSocketAddress(port), 1024);
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                SelectionKey key = null;
                while(iterator.hasNext()){
                    key = iterator.next();
                    iterator.remove();
                    handleInput(key);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        //多路复用器（selector）关闭后，所有注册在上面的Channel和Pipe等资源都会被自动注销并关闭，所以不需要重复释放资源
        if (selector != null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key){
        if(key.isValid()){
            //处理新接入的请求消息
            if(key.isAcceptable()){
                //同意新连接
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                try {
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    //注册新连接到多路复用器selecter
                    sc.register(selector, SelectionKey.OP_READ);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (key.isReadable()){
                //读取数据
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                try {
                    int readBytes = sc.read(readBuffer);
                    if (readBytes > 0){
                        readBuffer.flip();
                        byte[] bytes = new byte[readBuffer.remaining()];
                        readBuffer.get(bytes);
                        String body = new String(bytes, "utf-8");
                        System.out.println("The time server receive order : " + body);
                        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                        System.out.println(currentTime);
                        doWrite(sc, currentTime);
                    }else if(readBytes < 0){
                        //对端链路关闭
                        key.cancel();
                        sc.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if(key != null){
                        key.cancel();
                        if(key.channel() != null)
                            try {
                                key.channel().close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                    }
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String resp){
        if(resp != null && resp.trim().length() > 0){
            byte[] bytes = resp.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            System.out.println("dowrite = " + resp);
            try {
                channel.write(writeBuffer);
                if (!writeBuffer.hasRemaining()) {
                    System.out.println("Send order 2 client succeed.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
