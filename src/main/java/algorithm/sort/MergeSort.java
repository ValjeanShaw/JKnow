package algorithm.sort;

import java.util.Arrays;

/**
 * @author xiaoran
 * @date 2020/04/27
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {56, 2, 83, 3, 27, 98, 4, 31, 9};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);

        Arrays.stream(arr).forEach(e -> System.out.println(e));

        int[] arr1 = {};
        mergeSort.mergeSort(arr);

        Arrays.stream(arr1).forEach(e -> System.out.println(e));
    }

    /**
     * @param arr
     */
    public void mergeSort(int[] arr) {
        if (arr != null && arr.length > 0) {
            sort(arr, 0, arr.length - 1);
        }
    }


    /**
     * 拆分到不能拆分，然后合并有序的
     *
     * @param arr
     * @param left
     * @param right
     */
    public void sort(int[] arr, int left, int right) {
        //拆分到不能拆为止
        if (left < right) {
            int mid = (left + right) / 2;
            //拆分左边排序   mid为右边界
            sort(arr, left, mid);
            //拆分右边排序   mid为左边界
            sort(arr, mid + 1, right);

            //合并上面两个有序的
            merge(arr, left, mid, right);
        }
    }

    /**
     * 用一个临时数组   合并两个有序的数组
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int l = left;
        int h = mid + 1;
        int i = left;
        while (l <= mid && h <= right) {
            if (arr[l] <= arr[h]) {
                temp[i++] = arr[l++];
            } else {
                temp[i++] = arr[h++];
            }
        }
        //将左边剩余元素填充进temp中
        while (l <= mid) {
            temp[i++] = arr[l++];
        }
        //将右序列剩余元素填充进temp中
        while (h <= right) {
            temp[i++] = arr[h++];
        }

        //复制回原数组
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

    }

}
