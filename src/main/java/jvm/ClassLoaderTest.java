package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoran
 * @date 2020/06/09
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        //一个ArrayList的两个对象的getClass()得到的结果相同么
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        System.out.println(list.getClass() == list2.getClass());

    }
}
