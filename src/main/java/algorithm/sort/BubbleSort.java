package algorithm.sort;

import java.util.Arrays;

/**
 * @author xiaoran
 * @date 2020/04/25
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {56,2,83,3,27,98,4,31,9};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);

        Arrays.stream(arr).forEach(e-> System.out.println(e));

        int[] arr1 = {};
        bubbleSort.sort(arr1);

        Arrays.stream(arr1).forEach(e-> System.out.println(e));
    }

    /**
     * 冒泡排序   从小到大
     * @param arr
     */
    public void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
