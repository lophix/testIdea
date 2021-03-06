package niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 客户端处理类
 *
 * @Authuor Administrator
 * @Create 2016-09-03-17:12
 */
public class TimeClientHandle implements Runnable {
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        doConnect();
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                SelectionKey key = null;
                while (iterator.hasNext()) {
                    key = iterator.next();
                    //System.out.println("run =" + key);
                    iterator.remove();
                    handleInput(key);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private void handleInput(SelectionKey key) {
        if (key.isValid()) {
            //判断是否连接成功
            SocketChannel sc = (SocketChannel) key.channel();
            try {
                if (key.isConnectable()) {
                    if (sc.finishConnect()) {
                        System.out.println("connect finish");
                        sc.register(selector, SelectionKey.OP_READ);
                        doWrite(sc);
                    }else{
                        System.exit(1);  //连接失败，进程退出
                    }
                    if(key.isReadable()){
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        System.out.println("come in");
                        int readBytes = sc.read(readBuffer);
                        if(readBytes > 0) {
                            readBuffer.flip();
                            byte[] bytes = new byte[readBuffer.remaining()];
                            readBuffer.get(bytes);
                            String body = new String(bytes, "utf-8");
                            System.out.println("Now is : " + body);
                            this.stop = true;
                        }else if(readBytes < 0){
                            //对端链路关闭
                            key.cancel();
                            sc.close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                if(key != null){
                    key.cancel();
                    if(key.channel() != null){
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

    private void doConnect() {
        try {
            //如果直接连接成功，注册到多路复用器上，发送请求消息，读应答消息
            if (socketChannel.connect(new InetSocketAddress(host, port))) {
                socketChannel.register(selector, SelectionKey.OP_READ);
                System.out.println("connect succeed");
                doWrite(socketChannel);
            } else { //否则注册到多路复用器上，连接就绪
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
                System.out.println("connect fail");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void doWrite(SocketChannel socketChannel) {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        try {
            socketChannel.write(writeBuffer);
            if (!writeBuffer.hasRemaining()) {
                System.out.println("Send order 2 server succeed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
