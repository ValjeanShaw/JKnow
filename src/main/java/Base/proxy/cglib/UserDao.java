package Base.proxy.cglib;

/**
 * @author xiaoran
 * @date 2020/05/13
 *
 * 真是被执行的对象
 */
public class UserDao {
    public void save(){
        System.out.println("操作DB,存储数据");
    }
}
