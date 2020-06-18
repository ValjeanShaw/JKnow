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



}
