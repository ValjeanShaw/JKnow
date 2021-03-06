package algorithm.dp;

/**
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoran
 * @date 2020/06/12
 */
public class MaxProfit2 {


    /**
     * 动态规划 两个状态，比前面大就加起来，比前面小就不动
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //极值
        if(prices == null || prices.length == 0){
            return 0;
        }

        int[] dp = new int[prices.length];

        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                dp[i] = dp[i-1]+(prices[i]-prices[i-1]);
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[prices.length-1];
    }

    /**
     * 状态压缩，空间复杂度压缩到 o1
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        //极值
        if(prices == null || prices.length == 0){
            return 0;
        }

        int last = 0;
        int now = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                now = last+(prices[i]-prices[i-1]);
                last = now;
            }
        }
        return now;
    }
}
