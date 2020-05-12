package Base.proxy.dynamicproxy;

/**
 * @author xiaoran
 * @date 2020/04/18
 */
public class Taco implements SellFood {
    @Override
    public void sellFood() {
        System.out.println("Taco Tuesday, gi gi gi gi gi gi......");
    }
}
