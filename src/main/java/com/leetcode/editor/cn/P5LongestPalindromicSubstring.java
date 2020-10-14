package com.leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2770 👎 0

public class P5LongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            int maxLen = 1;
            int start = 0;
            char[] charArray = s.toCharArray();
            // 开启两个指针分别向右边递推
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }

        /**
         * 验证子串 s[left..right] 是否为回文串
         */
        private boolean validPalindromic(char[] charArray, int left, int right) {
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
