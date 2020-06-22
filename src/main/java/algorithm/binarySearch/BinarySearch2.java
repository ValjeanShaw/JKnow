package algorithm.binarySearch;

/**
 *
 * 二分查找的模板2
 * 用于查找需要访问数组中当前索引及其直接右邻居索引的元素或条件。
 *
 * @author xiaoran
 * @date 2020/06/22
 */
public class BinarySearch2 {


    public int binarySearch(int[] nums,int target){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        //这儿有区别
        int right = nums.length;
        while(right > left){
            int mid = left + ((right-left)>>1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<target){
                left = mid +1;
            }
            if(nums[mid]>target){
                //这儿有区别
                right = mid;
            }
        }
        if(left != nums.length && nums[left] == target){
            return left;
        }
        return -1;
    }
}
