package netty.chat.bean;

/**
 * User's information
 *
 * @Authuor Administrator
 * @Create 2016-10-27-10:38
 */
public class UserInfo {
    private String userName;
    private int userID;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserInfo(){

    }

    public UserInfo(String userName, int userID){
        this.userID = userID;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
