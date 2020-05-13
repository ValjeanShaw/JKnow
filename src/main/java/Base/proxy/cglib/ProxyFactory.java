package Base.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiaoran
 * @date 2020/05/13
 *
 * 代理对象
 *
 */
public class ProxyFactory implements MethodInterceptor {
    /**
     * 维护一个目标对象
     */
    private Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }


    /**
     * 为目标对象生成代理对象
     * @return
     */
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    /**
     * 可重写该方法，进行代理功能增强
     *
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开启事务");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }


}
