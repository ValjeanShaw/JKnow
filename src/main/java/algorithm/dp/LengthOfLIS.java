package algorithm.dp;

/**
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoran
 * @date 2020/05/26
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        LengthOfLIS lis = new LengthOfLIS();
        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length ==1){
            return 1;
        }

        //dp数组，代表到第n个数字时 子序列长度
        int[] dp = new int[nums.length];
        //初始化
        dp[0] = 1;
        int maxValue = 1;
        for(int i=0;i<dp.length;i++){
            //找出比当前值小的最长序列长度
            int maxCurrentValue = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxCurrentValue = Math.max(maxCurrentValue,dp[j]);
                }
            }
            //之前的值都比现在小，所以这里要加上当前数值的1
            dp[i] = maxCurrentValue +1;
        }
        return dp[nums.length-1];
    }

}
