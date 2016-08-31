package sington.test;

/**
 * 这是一个单例测试类
 *
 * @Authuor Administrator
 * @Create 2016-08-31-20:47
 */
public class SingletonTest {
    public  static  void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();
        String str = "你好，单例模式！";
        mySingleton.singletonPrint(str);
    }
}
