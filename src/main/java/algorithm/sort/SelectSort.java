package algorithm.sort;

import java.util.Arrays;

/**
 * @author xiaoran
 * @date 2020/04/28
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {56,2,83,3,27,98,4,31,9};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(arr);

        Arrays.stream(arr).forEach(e-> System.out.println(e));

        int[] arr1 = {};
        selectSort.sort(arr1);

        Arrays.stream(arr1).forEach(e-> System.out.println(e));
    }

    /**
     * 选择排序  从小到大排序
     * @param arr
     */
    public void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
