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
