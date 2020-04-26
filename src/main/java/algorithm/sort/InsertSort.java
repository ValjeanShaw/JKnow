package algorithm.sort;

import java.util.Arrays;

/**
 * @author xiaoran
 * @date 2020/04/25
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {56,2,83,3,27,98,4,31,9};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(arr);

        Arrays.stream(arr).forEach(e-> System.out.println(e));

        int[] arr1 = {};
        insertSort.sort(arr1);

        Arrays.stream(arr1).forEach(e-> System.out.println(e));
    }


    /**
     * 插入排序
     */
    public void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
