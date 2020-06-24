package algorithm.binarySearch;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author xiaoran
 * @date 2020/06/24
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] re = sr.searchRange(new int[]{5,7,7,8,8,10},8);
        System.out.println(re[0]+"-"+re[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0]=leftRange(nums,target);
        result[1]=rightRange(nums,target);
        return result;
    }

    /**
     * 寻找左边界
     * @param nums
     * @param target
     * @return
     */
    public int leftRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //退出条件是 left > right  极值  left = nums.length
        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid +1;
            }else if(nums[mid] == target){
                //压缩右边界，不断向左逼近
                right = mid-1;
            }
        }

        //nums[mid] == target  right可能-1了，所以要按照left来返回
        if(left == nums.length || nums[left] !=target){
            //找遍了范围内数据都没找到
            return -1;
        }

        return left;
    }

    /**
     * 寻找右边边界
     * @param nums
     * @param target
     * @return
     */
    public int rightRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //退出条件是 left > right  极值  left = nums.length
        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid +1;
            }else if(nums[mid] == target){
                //压缩左边界，不断向右逼近
                left = mid+1;
            }
        }

        //nums[mid] == target  left可能+1了，所以要按照right来返回
        if(right < 0 || nums[right] !=target){
            //找遍了范围内数据都没找到
            return -1;
        }

        return right;
    }
}
