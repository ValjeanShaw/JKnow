package algorithm.highFre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 *
 * @author xiaoran
 * @date 2020/07/15
 */
public class WordBreak {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode",wordDict));

    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }

        //dp[n] 代表 从 0~n 的值是否都包含
        boolean[] dp = new boolean[s.length()+1];

        //初始化
        dp[0] = true;

        for(int i=1;i<dp.length;i++){
            for(int j = i-1;j>=0;j--){
                dp[i] = dp[j] && set.contains(s.substring(j,i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
