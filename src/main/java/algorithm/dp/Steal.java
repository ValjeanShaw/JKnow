package algorithm.dp;

/**
 * leetcode 198. 打家劫舍
 *
 *
 * https://leetcode-cn.com/problems/house-robber/
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * @author xiaoran
 * @date 2020/05/19
 */
public class Steal {

    public static void main(String[] args) {
        Steal steal = new Steal();
        int[] nums = {2,1,1,2,3,4,3};
        System.out.println(steal.rob(nums));
    }

    public int rob(int[] nums) {
        //一些特殊的条件
        if(nums == null || nums.length<=0){
            return 0;
        }

        //定义dp数组
        //dp[i] 代表到达第 i 个房屋偷得的最高金额，也就是当前最大子序和
        int[] dp = new int[nums.length+1];

        //初始化的值
        dp[0] = 0;
        dp[1] = nums[0];
        //确定元素间的动态关系
        for(int i=2;i<=nums.length;i++){
            //当前房间偷与不偷， 两种结果最优值对比
            dp[i] = Math.max((nums[i-1] + dp[i-2]),dp[i-1]);
        }
        return dp[nums.length];
    }

    /**
     * 在上一个动态规划上进行优化的方案
     * @param nums
     * @return
     */
    public int rob1(int[] nums){
        if(nums == null || nums.length<=0){
            return 0;
        }

        if(nums.length ==1){
            return nums[0];
        }

        //不需要定义dp数组，每个元素只与dp[i-2]   dp[i-1] 有关，那么只需要记录这两条相关的即可
        int low = 0;
        int high = nums[0];
        int current=0;

        for(int i=2;i<=nums.length;i++){
            current = Math.max((nums[i-1] + low),high);
            low = high;
            high = current;
        }
        return current;
    }
}
