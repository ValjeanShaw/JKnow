package algorithm.dp;

/**
 * 写一个函数，输入n，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 *
 *
 * 斐波拉契数列的递归实现和动态规划实现
 *
 * 主要从中展示出动态规划的以空间换时间，避免重复计算的优势
 *
 * @author xiaoran
 * @date 2020/05/18
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        int n = 3;
        System.out.println(fibonacci.fib(n-1));

        System.out.println(fibonacci.fibDp(n));
    }

    /**
     * 递归方式实现
     *
     * 有很多重复计算
     * @param n
     * @return
     */
    public int fib(int n){

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }


    /**
     * 划分出数组dp，保存重复计算的结果
     *
     * F(2) = F(0) + F(1) --> 保存 F(2)
     * @param n
     * @return
     */
    public int fibDp(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n-1];
    }
}
