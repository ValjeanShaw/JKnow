package algorithm.binarySearch;

/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author xiaoran
 * @date 2020/06/21
 */
public class SearchNode {

    public static void main(String[] args) {
        SearchNode searchNode = new SearchNode();
        int index = searchNode.search(new int[]{4,5,6,7,0,1,2},0);
        System.out.println(index);

        index = searchNode.search(new int[]{4},0);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        if(nums==null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;

        while(high >= low){
            int mid = low + ((high-low) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
