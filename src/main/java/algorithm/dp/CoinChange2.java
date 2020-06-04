package algorithm.dp;

/**
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author xiaoran
 * @date 2020/06/04
 */
public class CoinChange2 {

    /**
     * 完全背包问题   即背包无限
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        //dp[i][j]   只使用前i个硬币 价值为j 时候  此时的凑单方法总数
        int[][] dp =new int[coins.length+1][amount+1];

        //初始化   价值为0时，凑单总数为1
        for(int i=0;i<=coins.length;i++){
            dp[i][0] = 1;
        }

        //状态转移方程
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    //当前硬币不可选
                    dp[i][j] = dp[i-1][j];
                }else{
                    //当前硬币可选  那么当前硬币选上，选上后剩余的总数，再加上之前的硬币元素
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

}
