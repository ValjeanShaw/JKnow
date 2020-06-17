package algorithm.highFre;

/**
 * @author xiaoran
 * @date 2020/06/17
 */
public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
        MaxScoreSightseeingPair ms = new MaxScoreSightseeingPair();
        System.out.println(ms.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }

    public int maxScoreSightseeingPair(int[] A) {
        if(A == null || A.length==0){
            return 0;
        }
        //初始值
        int max = A[0] +0;
        int sum = 0;
        for(int i=1;i<A.length;i++){
            sum = Math.max(A[i] - i + max,sum);
            max = Math.max(max,A[i]+i);
        }
        return sum;
    }
}
