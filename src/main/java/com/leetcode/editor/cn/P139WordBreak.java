package com.leetcode.editor.cn;
//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 动态规划
// 👍 788 👎 0

import java.util.Arrays;
import java.util.List;

public class P139WordBreak {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int length = s.length();
            boolean[] dp = new boolean[length + 1];
            Arrays.fill(dp, false);
            dp[0] = true;
            for (int i = 0; i < length; i++) {
                if (!dp[i]) {
                    continue;
                }
                for (String word : wordDict) {
                    if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                        dp[i + word.length()] = true;
                    }
                }
            }
            return dp[length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
