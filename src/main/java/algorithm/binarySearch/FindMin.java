package algorithm.binarySearch;

/**
 * @author xiaoran
 * @date 2020/06/22
 */
public class FindMin {

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin.findMin1(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin.findMid2(new int[]{4,5,6,7,0,1,2}));
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (high > low) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid]<nums[high]) {
                //肯定不是最小
                high = mid;
            }else{
                low = mid +1;
            }
        }
        return nums[low];
    }

    public int findMin1(int[] nums){
        //极值
        if(nums.length == 1){
            return nums[0];
        }

        int low = 0;
        int high = nums.length-1;

        if(nums[high]>nums[0]){
            return nums[0];
        }
        while(high>=low){
            int mid = low+((high-low)>>1);

            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }

            if(nums[mid]>nums[0]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    public int findMid2(int[] numbers){
        int left =0;
        int right = numbers.length-1;

        while(left < right){
            int mid = left + ((right-left)>>1);
            if(numbers[mid]>numbers[right]){
                left = mid +1;
            }else if(numbers[mid]<numbers[right]){
                right = mid;
            }else{
                right--;
            }
        }

        return numbers[left];
    }
}
