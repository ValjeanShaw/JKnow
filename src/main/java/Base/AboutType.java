package Base;

/**
 * @author xiaoran
 * @date 2020/04/25
 */
public class AboutType {
    public static void main(String[] args) {
        Integer a = new Integer(9);
        Integer b = new Integer(9);
        System.out.println(a == b);

        Integer c = 9;
        Integer d = 9;
        System.out.println(c == d);

        Integer e = 200;
        Integer f = 200;
        System.out.println(e == f);

        int g = 200;
        Integer h = 200;
        System.out.println(g == h);

        int j = 100;
        Integer k = 100;
        System.out.println(j == k);
    }
}
