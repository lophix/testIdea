package main.util;

import java.util.*;

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
        return new ArrayList<>();
    }

}
