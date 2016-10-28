package netty.chat.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * use jdbc connect db
 *
 * @Authuor Administrator
 * @Create 2016-10-27-15:50
 */
public class DBConnecter {

    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null) {
            String url = "jdbc:mysql://139.196.187.152:3306/chatdb?"
                    + "user=root&password=Lophix123&useUnicode=true&characterEncoding=UTF8&autoReconnect=true&useSSL=false";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
