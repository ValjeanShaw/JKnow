package Base;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaoran
 * @date 2020/04/29
 */
public class AboutHashMap {

    public static void main(String[] args) throws Exception{
        Map<String,String> map = new HashMap<>(3);

        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        map.put("4","1");

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));


        //HashMap 可以存储key-value 为null的数据
        Map<String,String> map1  = new HashMap<>();
        map1.put(null,"123");
        map1.put("123",null);

        map1.entrySet().forEach(System.out::println);


        //ConcurrentHashMap 不存储key-value 为null的数据
        Map<String,String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(null,"123");
        concurrentMap.put("123",null);

        concurrentMap.entrySet().forEach(System.out::println);
    }
}
