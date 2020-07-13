package algorithm.highFre;

/**
 * @author xiaoran
 * @date 2020/07/13
 */
public class Merge {

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums = new int[]{1,2,3,0,0,0};
        merge.merge(nums,3,new int[]{2,5,6},3);

        System.out.println(nums);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int high = m - 1;
        int low = n - 1;

        while(high>=0 && low >=0){
            nums1[index--] = nums1[high] >= nums2[low]?nums1[high--]:nums2[low--];
        }
        for(int i=low;i>=0;i--){
            nums1[index--] = nums2[low--];
        }
    }
}
