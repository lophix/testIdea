package biotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 测试TimeServer的线程
 *
 * @Authuor Administrator
 * @Create 2016-09-03-11:35
 */
public class TimeServerHandler implements Runnable {
    private Socket socket;
    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while(true){
                body = in.readLine();
                if(body != null){
                    System.out.println("The time server receive order:" + body);
                    currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
                    out.println(currentTime);
                }else {
                    System.out.println("The body is null");
                }
            }
        } catch (IOException e) {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                    out = null;
                }
                if(this.socket != null){
                    this.socket.close();
                    this.socket = null;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
