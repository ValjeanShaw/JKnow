package algorithm.dp;

/**
 * leetcode 62
 * 不同路径
 * <p>
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author xiaoran
 * @date 2020/05/20
 */
public class RobotRoute {

    public static void main(String[] args) {
        RobotRoute robotRoute = new RobotRoute();
        System.out.println(robotRoute.uniquePaths(3,7));
        System.out.println(robotRoute.uniquePaths1(3,7));
        System.out.println(robotRoute.uniquePaths2(3,7));
    }

    public int uniquePaths(int m, int n) {
        //先考虑极值
        if (m <= 0 || n <= 0) {
            return 0;
        }

        //边界，始终为1
        if(m==1 && n== 1){
            return 1;
        }


        //动态规划第一步  设定dp数组
        //这里根据路径，设计二维数组，记录到当前位置的路径总条数
        int[][] dp = new int[m][n];

        //初始值  第一个位置只有一条路
        dp[0][0] = 1;
        //边界值都为1
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }

        //转换方程：  当前元素值只与上方和左方路径相关， 相加即可
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 优化方案，在上文基础上，将dp二维数组的空间存储降到最低
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        //先考虑极值
        if (m <= 0 || n <= 0) {
            return 0;
        }
        //边界，始终为1
        if(m==1 && n== 1){
            return 1;
        }

        //按行计算，可以省略掉n-1行之外的行，因此可以将dp[m][n] 降低到 2个 dp[n]
        //初始值  上一行和当前行
        int[] dpLast = new int[n];
        int[] dpNow = new int[n];
        for(int i=0;i<n;i++){
            dpLast[i] = 1;
        }
        dpNow[0] = 1;


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpNow[j] = dpNow[j-1] + dpLast[j];
                dpLast[j] = dpNow[j];
            }
        }
        return dpNow[n-1];
    }

    /**
     * 第二种优化方案
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n){
        //先考虑极值
        if (m <= 0 || n <= 0) {
            return 0;
        }
        //边界，始终为1
        if(m==1 && n== 1){
            return 1;
        }

        //只保留 up 和 left,按行缩减，只保留当前所在的行
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }

}
