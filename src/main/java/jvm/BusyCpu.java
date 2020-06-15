package jvm;

/**
 * @author xiaoran
 * @date 2020/06/13
 */
public class BusyCpu {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                int result = 0;
                while (true) {
                    result++;
                    if (result > Integer.MAX_VALUE / 2) {
                        result = 0;
                    }
                    System.out.println(result);
                }
            }
        }.start();
    }
}
