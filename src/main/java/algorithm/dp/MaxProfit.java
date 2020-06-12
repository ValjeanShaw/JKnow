package algorithm.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoran
 * @date 2020/06/12
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit(new int[]{1,2}));
    }

    public int maxProfit(int[] prices) {
        //极值
        if (prices == null || prices.length == 0) {
            return 0;
        }

        //定义dp数组，表示到 第n个数时，最大的收益值
        int[] dp = new int[prices.length];

        dp[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            for (int j = i; j >= 0; j--) {
                if(prices[i] > prices[j]){
                    dp[i] = Math.max(dp[i],prices[i]-prices[j]);
                }
            }
            dp[i] = Math.max(dp[i],dp[i-1]);
        }

        return dp[prices.length-1];
    }
}
