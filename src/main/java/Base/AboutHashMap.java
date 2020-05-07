package Base;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
    }
}
