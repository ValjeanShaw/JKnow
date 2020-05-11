package Base.proxy.staticproxy;

/**
 * @author xiaoran
 * @date 2020/04/18
 */
public class TestProxy {
    public static void main(String[] args) {
        Movie titanicMovie = new TitanicMovie();

        Cinema cinema = new Cinema(titanicMovie);

        cinema.receiveAds("让天下没有难做的生意");
        cinema.play();
    }
}
