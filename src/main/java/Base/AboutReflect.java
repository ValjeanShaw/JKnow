package Base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xiaoran
 * @date 2020/05/07
 */
public class AboutReflect {
    public static void main(String[] args) {
        try {
            //获取class对象
            Class cla = Class.forName("Base.ObjectTest");




            //class对象创建实例对象方式一
            ObjectTest objectTest = (ObjectTest) cla.newInstance();

            //class对象创建实例对象方式二
            Constructor constructor = cla.getConstructor(int.class, String.class);
            ObjectTest objectTest1 = (ObjectTest) constructor.newInstance(12, "abc");





            //获取 constructor数组及指定constructor
            Constructor[] constructors = cla.getConstructors();

            Constructor constructor0 = cla.getConstructor();
            Constructor constructor1 = cla.getConstructor(int.class,String.class);
            //可以获取非public的构造函数
            Constructor constructor2 = cla.getDeclaredConstructor(int.class);
            System.out.println(constructor2.getParameterCount());

            for(Constructor cons:constructors){
                System.out.println(cons.getParameterCount());
            }





            //获取属性
            Field[] fields = cla.getFields();
            System.out.println("field数量："+fields.length);

            //获取属性的注解，拿到超级权限，然后注入到指定对象
            Field fieldId = cla.getDeclaredField("id");
            fieldId.setAccessible(true);
            fieldId.set(objectTest,fieldId.getAnnotation(TestAnnotation.class).id());

            System.out.println(objectTest.toString());




            //获取方法 并使用指定对象访问
            Method method = cla.getDeclaredMethod("print",int.class,String.class);
            method.invoke(objectTest,996,"icu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ObjectTest {
    @TestAnnotation(id=123)
    private long id;
    private String name;

    public ObjectTest() {
    }

    public ObjectTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected ObjectTest(int id){
        this.id = id;
    }

    public void print(int id,String name){
        System.out.println(id+"==="+name);
    }

    @Override
    public String toString() {
        return "ObjectTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotation {

    int id() default 1;

}