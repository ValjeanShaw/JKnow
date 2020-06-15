package jvm;

/**
 * 模拟 OutofMemoryError情况
 *
 * -Xmx10m -Xms10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=oom.out
 *
 * @author xiaoran
 * @date 2020/06/15
 */
public class OomDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        while(true){
            stringBuilder.append(System.currentTimeMillis());
        }
    }
}
