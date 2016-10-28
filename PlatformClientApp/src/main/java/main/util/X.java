package main.util;


import java.util.*;

/**
 * Created by pingxin on 2015/12/16.
 */
public class X {
    /**
     * 泛型静态工厂方法
     */
    public static <E> Set<E> createSet(){
        return new HashSet<E>();
    }

    /**
     * 创建默认初始化大小为2的map
     */
    public static <K,V> Map<K,V> createMap(){
        return createMap(2);
    }

    public static  <K,V> Map<K,V> createMap(int initialSize){
        return new HashMap<>(initialSize);
    }

    public static <E> List<E> createArrayList(){
        return new ArrayList<E>();
    }

    public static byte[] createArrays(int length){
        return new byte[length];
    }




    public void test(){
        Map<String, String> map = createMap();
        Set<String> set = createSet();
    }


}
