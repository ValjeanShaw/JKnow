package algorithm.binarySearch;

/**
 * @author xiaoran
 * @date 2020/06/21
 */
public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(8));
        System.out.println(mySqrt.mySqrt(6));
        System.out.println(mySqrt.mySqrt(1));
    }

    public int mySqrt(int x) {
        int left=0;
        int right = x;
        int result = -1;
        while(right >= left){
            int num = (left+right)/2;
            if((long)num*num <= x){
                result = num;
                left = num+1;
            }else{
                right = num-1;
            }
        }
        return result;
    }
}
