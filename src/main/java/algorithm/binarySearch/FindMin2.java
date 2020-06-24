package algorithm.binarySearch;

/**
 * 单增  单减   先减后增 函数   找到最小值
 *
 * @author xiaoran
 * @date 2020/06/24
 */
public class FindMin2 {

    public static void main(String[] args) {
        FindMin2 findMin2 = new FindMin2();
        System.out.println(findMin2.findMin(new int[]{1,2,3,4,5,6}));
        System.out.println(findMin2.findMin(new int[]{9,8,7,6,5,4}));
        System.out.println(findMin2.findMin(new int[]{9,8,7,6,5,4,1,2,3,4,5,6}));

    }

    public int findMin(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(right >= left){
            int mid = left + ((right - left)>>1);
            if(mid == 0 || mid == nums.length-1){
                return nums[mid];
            }

            if(nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1]){
                return nums[mid];
            }

            if(nums[mid]>nums[mid+1]){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
