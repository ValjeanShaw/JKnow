package Base.proxy.dynamicproxy;

/**
 *
 * 真正被代理对象
 *
 * @author xiaoran
 * @date 2020/04/18
 */
public class Maotai implements SellWine {


    @Override
    public void sell() {
        System.out.println("国酒茅台");
    }

    @Override
    public void stock() {
        System.out.println("茅台正在补货中。。。");
    }
}
