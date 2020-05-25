package algorithm.dp;

/**
 * leetcode 213  打家劫舍2
 *
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 *
 * @author xiaoran
 * @date 2020/05/22
 */
public class Steal2 {

    public static void main(String[] args) {
        Steal2 steal = new Steal2();
        int[] nums = {1,1};
        System.out.println(steal.rob(nums));
    }

    /**
     * 环形打家劫舍
     *
     * 环形的情况中，只需要考虑首尾的情况，去首留尾  留首去尾   两个数组，然后将其转换为打家劫舍1即可
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //考虑极值
        if(nums == null || nums.length <= 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        //留首
        int low = 0;
        int high = nums[0];
        int maxHead = 0;
        for(int i=2;i<=nums.length-1;i++){
            maxHead = Math.max(high,low+nums[i-1]);
            low = high;
            high = maxHead;
        }

        //留尾
        low = 0;
        high = nums[1];
        int maxTail = 0;
        for(int i=3;i<=nums.length;i++){
            maxTail = Math.max(high,low+nums[i-1]);
            low = high;
            high = maxTail;
        }

        return Math.max(maxHead,maxTail);
    }

}
