package algorithm.digui;

/**
 * @author xiaoran
 * @date 2020/05/08
 */
public class DecodeChar {

    public static void main(String[] args) {
        DecodeChar decodeChar = new DecodeChar();
        System.out.println(decodeChar.numDecodings("000"));
    }
    public int numDecodings(String s) {
        //以0开头的  无法编码出来
        if(s.startsWith("0")){
            return 0;
        }
        return getNumber(s.toCharArray(),s.length()-1);
    }

    public int getNumber(char[] arr,int index){
        //结束条件
        if(index<=0){
            return 1;
        }

        int count = 0;

        char preChar = arr[index-1];
        char currentChar = arr[index];

        // 只看当前位置的数量，由于n-1的解码已定，此处数量不会改变，将还是 n-1 的数量
        if(currentChar > '0'){
            count += getNumber(arr,index-1);
        }

        // 两位数组成如果在 10-26 之间，那么解码根据 n-2 的数量决定
        if(preChar == '1' || (preChar == '2' && currentChar <= '6')){
            count += getNumber(arr,index -2);
        }

        return count;
    }
}
