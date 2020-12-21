package com.leetcode.editor.cn;
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同
//
//
//
// 示例 1：
//
//
//输入：s = "bcabc"
//输出："abc"
//
//
// 示例 2：
//
//
//输入：s = "cbacdcbc"
//输出："acdb"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 由小写英文字母组成
//
// Related Topics 栈 贪心算法 字符串
// 👍 383 👎 0

import java.util.HashSet;

public class P316RemoveDuplicateLetters {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public String removeDuplicateLetters(String s) {
            HashSet<Character> characters = new HashSet<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (characters.contains(s.charAt(i))) {
                    continue;
                }
                characters.add(s.charAt(i));
                stringBuilder.append(s.charAt(i));
            }
            return stringBuilder.toString();
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            String s = "cbacdcbc";
            System.out.println(solution.removeDuplicateLetters(s));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
