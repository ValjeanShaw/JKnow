package algorithm.hash;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author xiaoran
 * @date 2020/06/30
 */
public class HappyNum {

    public static void main(String[] args) {
        HappyNum happyNum = new HappyNum();
        System.out.println(happyNum.isHappy(0));
        System.out.println(happyNum.isHappy(1));
        System.out.println(happyNum.isHappy(68));
        System.out.println(happyNum.isHappy(33));
    }

    /**
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if(n == 0){
            return false;
        }
        if(n==1){
            return true;
        }

        Set<Integer> set = new HashSet<>();
        while(true){
            int sum = 0;
            while(n!=0){
                int temp = n%10;
                sum += (temp*temp);
                n = n/10;
            }
            if(sum==1){
                return true;
            }else if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            n=sum;
        }
    }
}
