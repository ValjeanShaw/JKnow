package algorithm.dp;

/**
 * 最常说的 0-1 背包问题。描述：
 *
 * 给⼀个可装载重量为 W 的背包和N个物品，每个物品都有重量和价值两个。
 * 其中第 i 个物品的重量为 wt[i] ，价值为 val[i] ，现在让你⽤这个背包装物品，最多能装的价值是多少？
 *
 * 例⼦，输⼊如下：
 *
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 *
 * 输出 6
 *
 * @author xiaoran
 * @date 2020/06/01
 */
public class Pack {

    public static void main(String[] args) {
        Pack pack = new Pack();
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        System.out.println(pack.maxValue(4,3,wt,val));
    }


    public int maxValue(int w,int n,int[] wt,int[] val){
        //定义dp数组  当i个背包时，背包重量为j，这种情况下可以装的最大价值
        int[][] dp = new int[n+1][w+1];

        //初始化数据    横纵坐标为0时，值都为0

        //状态转移方程
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                //先判断当前背包重量是否超了，如果超了，则一定不可选，那么选择没有这个背包的最佳状态
                if(j<wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //选择这个和不选择这个的最佳状态
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[n][w];
    }
}
