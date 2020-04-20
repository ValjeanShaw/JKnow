package Base;

/**
 * @author xiaoran
 * @date 2020/04/19
 */
public class AboutString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));


        //这句话创建了多少个对象
        String s3 = new String("abc");


        String s4 = "jam";
        String s5 = new String("jam");
        System.out.println(s4 == s5);
        System.out.println(s4.equals(s5));

        String s6 = "p"+"e"+"k";
        String s7 = "pek";
        System.out.println(s6 == s7);
        System.out.println(s6.equals(s7));

        String s8 = "ab";
        String s9 = "abc";
        String s0 = s8+"c";
        System.out.println(s9 == s0);
        System.out.println(s9.equals(s0));

    }
}
