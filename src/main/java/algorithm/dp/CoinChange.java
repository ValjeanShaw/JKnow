package algorithm.dp;

/**
 *
 * https://leetcode-cn.com/problems/coin-change/
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 *
 *
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoran
 * @date 2020/05/28
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange coin = new CoinChange();
        System.out.println(coin.coinChange(new int[]{2},3));
    }

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount <0){
            return -1;
        }

        //定义dp数组 n表示总额为n时候，需要的钱
        int[] dp = new int[amount+1];
        //初始化，dp[0] = 0   其它 = Int.MaxValue
        for(int i=1;i<=amount;i++){
            dp[i] = amount+1;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] +1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];

    }
}
