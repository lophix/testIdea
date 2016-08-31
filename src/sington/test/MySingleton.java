package sington.test;

/**
 * Created by Administrator on 2016/8/31.
 */
public class MySingleton {
    private static MySingleton ourInstance = new MySingleton();

    public static MySingleton getInstance() {
        return ourInstance;
    }

    private MySingleton() {
    }

    public void singletonPrint(String str){
        System.out.println("这是单例测试：" + str);
    }
}
