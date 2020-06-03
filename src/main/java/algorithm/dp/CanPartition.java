package algorithm.dp;

/**
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoran
 * @date 2020/06/02
 */
public class CanPartition {

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
//        System.out.println(canPartition.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition.canPartition(new int[]{1, 2,  5}));
    }

    /**
     * 转换为0-1 背包问题
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if(nums==null && nums.length==0){
            return false;
        }

        //如果综合是奇数，那不可能拆分
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        if(sum%2 ==1){
            return false;
        }

        //转换为背包问题   dp[i][j]   当选择第i个元素时，总值是j，是否能凑对成功
        boolean[][] dp = new boolean[nums.length+1][sum/2+1];

        /**
         * 初始化
         * base case 就是 dp[..][0] = true 和 dp[0][..] = false，
         * 因为剩余总价值没有空间的时候，就相当于装满了，而当没有物品可选择的时候，肯定没办法装满背包。
         */
        for(int i=0;i<nums.length;i++){
            dp[i][0] = true;
        }

        //状态转换方程
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum/2;j++){
                //如果总价值小于背包价值，背包不可选,沿用上一个背包逻辑
                if(j<nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //可选和不可选   只要有一个满足，当前就为true
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length][sum/2];
    }
}
