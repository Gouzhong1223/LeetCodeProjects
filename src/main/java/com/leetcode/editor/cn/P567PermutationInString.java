package com.leetcode.editor.cn;
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
// 示例1:
//
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
//
//
//
//
// 示例2:
//
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//
//
//
// 注意：
//
//
// 输入的字符串只包含小写字母
// 两个字符串的长度都在 [1, 10,000] 之间
//
// Related Topics 双指针 Sliding Window
// 👍 200 👎 0

import java.util.HashMap;

public class P567PermutationInString {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
            }
            int left = 0, right = 0, valid = 0;
            while (right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }
                // 这种情况需要收缩
                while (right - left >= s1.length()) {
                    if (valid == need.size()) {
                        return true;
                    }
                    char d = s2.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        if (need.get(d).equals(window.get(d))) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.checkInclusion("ab", "dboaoo"));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
