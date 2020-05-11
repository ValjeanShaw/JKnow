package Base.proxy.staticproxy;

/**
 *
 * 正在被代理对象
 *
 * @author xiaoran
 * @date 2020/04/18
 */
public class TitanicMovie implements Movie{
    @Override
    public void play() {
        System.out.println("正在播放电影《泰坦尼克号》");
    }
}
