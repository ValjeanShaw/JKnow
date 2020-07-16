package algorithm.highFre;

/**
 * @author xiaoran
 * @date 2020/07/16
 */
public class LongestString {
    public String longestString(String s){
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int i = 1; i < strLen; i++) {
            for (int j = 0; j < i; j++) {

                //状态转换方程
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        maxStart = j;
                        maxEnd = i;
                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
