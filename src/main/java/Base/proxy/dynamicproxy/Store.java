package Base.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 商店  代理商
 *
 * @author xiaoran
 * @date 2020/04/18
 */
public class Store implements InvocationHandler {

    private Object goods;



    public Object bind(Object object){
        this.goods = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        storeLogo();

        method.invoke(goods,args);
        return null;
    }


    private void storeLogo(){
        System.out.println("专业微商，诚信代理");
    }
}
