package algorithm.binarySearch;

/**
 * @author xiaoran
 * @date 2020/06/18
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearch(new int[]{-1,0,3,5,9,12},0,6,9);
        System.out.println(index);


        System.out.println(binarySearch.binarySearch(new int[]{-1,0,3,5,9,12},9));
    }

    /**
     * 递归方式的二分查找
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    public int binarySearch(int[] nums,int low,int high,int target){
        int index = -1;
        int mid = (low+high)/2;
        if(nums[mid]>target){
            index = binarySearch(nums,low,mid,target);
        } else if(nums[mid] < target){
            index = binarySearch(nums,mid+1,high,target);
        } else if(nums[mid]==target){
            index = mid;
        }
        return index;
    }


    /**
     * 二分查找的非递归版本
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        while(high > low){
            int mid = (low+high)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] > target){
                high = mid;
            }
            if(nums[mid] < target){
                low = mid +1;
            }
        }
        return -1;

    }
}
