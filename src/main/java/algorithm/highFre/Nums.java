package algorithm.highFre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两数之和-三数之和
 *
 * @author xiaoran
 * @date 2020/07/16
 */
public class Nums {

    public static void main(String[] args) {
        Nums nums = new Nums();
        List<List<Integer>> list = nums.twoNums(new int[]{1,1,1,2,2,3,3},4);
        System.out.println(list);
    }

    /**
     * 两数之和进阶版  将所有不重复的集合输出出来
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> twoNums(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;

        List<List<Integer>> list = new ArrayList<>();
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (target > sum) {
                low++;
            } else if (target < sum) {
                high--;
            } else {
                List<Integer> tempList = new ArrayList<>();
                int left = nums[low];
                int right = nums[high];
                tempList.add(left);
                tempList.add(right);
                list.add(tempList);
                //去重
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return list;
    }

}
