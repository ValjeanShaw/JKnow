package algorithm.dp.chapter1;

/**
 * 最经典双串
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * @author xiaoran
 * @date 2020/05/27
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("abcde","ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        //极值
        if(text1.equals("") || text2.equals("")){
            return 0;
        }

        //定义dp数组
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        //初始化

        //状态转移方程
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                //text 对应的所有需要 -1
                if(text1.charAt(i-1) == text2.charAt(j-1) ){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    //否则谁长听谁的
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
