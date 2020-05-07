package algorithm.digui;

/**
 * @author xiaoran
 * @date 2020/05/07
 */
public class Hano {

    public static void main(String[] args) {
        Hano hano = new Hano();
        hano.hano('A','B','C',3);
    }

    /**
     * 将n个在A 上的盘子通过B 移动到C
     *
     * 第一步  n-1的盘子 从 A 通过C 移动到 B
     * 第二步  n 从A 移动到 C
     * 第三步  n-1的盘子 从 B 通过A 移动到 C
     *
     * @param A
     * @param B
     * @param C
     * @param n
     */
    public void hano(char A,char B,char C,int n){
        //递归结束条件
        if(n<=0){
            return;
        }
        //n和n-1 的关系

        hano(A,C,B,n-1);
        System.out.println(A +" to " + C);
        hano(B,A,C,n-1);
    }
}
