package algorithm.highFre;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @author xiaoran
 * @date 2020/06/20
 */
public class MaxArrNum {
    public static void main(String[] args) {
        MaxArrNum maxArrNum = new MaxArrNum();
        System.out.println(maxArrNum.minNumber(new int[]{3, 32, 321}));
    }

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num:nums){
            list.add(String.valueOf(num));
        }
        list.sort((a,b)->(a+b).compareTo(b+a));

        StringBuilder sb = new StringBuilder();
        for(String str:list){
            sb.append(str);
        }

        return sb.toString();
    }


}
