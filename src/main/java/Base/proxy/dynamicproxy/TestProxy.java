package Base.proxy.dynamicproxy;

/**
 * @author xiaoran
 * @date 2020/04/18
 *
 *
 * 代理接口
 * 被代理对象
 * 被代理
 */
public class TestProxy {

    public static void main(String[] args) {
        Maotai maotai = new Maotai();
        SellWine sellWine =(SellWine) new Store().bind(maotai);
        sellWine.sell();
        sellWine.stock();

        System.out.println("-------------");

        //代理商直接代理第二类商品
        Taco taco = new Taco();
        SellFood sellFood = (SellFood) new Store().bind(taco);
        sellFood.sellFood();

    }
}
