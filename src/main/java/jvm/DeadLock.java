package jvm;

import java.util.Arrays;

/**
 * 制造一个死锁问题，使用JVM进行排查定位
 *
 * @author xiaoran
 * @date 2020/06/10
 */
public class DeadLock {
    //创建两个对象，用另个线程分别先后独占

    private Boolean flag1 = true;
    private Boolean flag2 = false;

    public static void main(String[] args) {
        System.out.println(args.length);
        Arrays.stream(args).forEach(System.out::println);
        DeadLock deadLock = new DeadLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1开始，作用是当flag1 = true 时，将flag2也改为 true");
                synchronized (deadLock.flag1){
                    if(deadLock.flag1){
                        try{
                            //睡眠1s ,模拟业务执行耗时
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println("flag1 = true,准备锁住flag2...");
                        synchronized (deadLock.flag2){
                            deadLock.flag2 = true;
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2开始，作用是当flag2 = false 时，将flag1也改为 false");
                synchronized (deadLock.flag2){
                    if(!deadLock.flag2){
                        try{
                            //睡眠1s ,模拟业务执行耗时
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println("flag2 = false,准备锁住flag1...");
                        synchronized (deadLock.flag1){
                            deadLock.flag1 = false;
                        }

                    }
                }
            }
        }).start();
    }
}
