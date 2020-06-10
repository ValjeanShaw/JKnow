package algorithm.dp;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoran
 * @date 2020/06/10
 */
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        LongestPalindromeSubseq ls = new LongestPalindromeSubseq();
        System.out.println(ls.longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        char[] arr = s.toCharArray();
        //dp[i][j] 子序列 i->j 的回文串长度   最终求的是 dp[0][n-1]
        int[][] dp = new int[arr.length][arr.length];
        //初始化   每个i=j的位置，都是1   每个j=0的位置，都是0，这个不用显式初始化
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = 1;
        }

        int n = arr.length;
        //从n-1求到0,所以反向遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    //如果二者相等，那么，原子序列向外扩张2
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //留下最大的
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
