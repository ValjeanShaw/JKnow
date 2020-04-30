package algorithm.sort;

import java.util.Arrays;

/**
 * @author xiaoran
 * @date 2020/04/30
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {56, 2, 83, 3, 27, 98, 4, 31, 9};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(e -> System.out.println(e));

        int[] arr1 = {};
        quickSort.sort(arr1, 0, 0);

        Arrays.stream(arr1).forEach(e -> System.out.println(e));
    }

    /**
     * 快速排序  从小到大
     *
     * @param arr
     */
    public void sort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0 || left > right) {
            return;
        }
        int low = left;
        int high = right;
        //基准数
        int base = arr[left];

        while (low != high) {
            //从右往左  遇到小的停下来
            while (arr[high] > base && low < high) {
                high--;
            }
            //从左往后   遇到大的停下来
            while (arr[low] < base && low < high) {
                low++;
            }
            //如果相等，就应该交换基准值了
            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }

        //交换基准值
        int baseTemp = base;
        base = arr[low];
        arr[low] = baseTemp;

        sort(arr, left, low - 1);
        sort(arr, high + 1, right);
    }
}
