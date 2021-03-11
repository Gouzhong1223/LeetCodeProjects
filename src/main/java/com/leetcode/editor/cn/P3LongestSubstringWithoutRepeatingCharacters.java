package com.leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4456 👎 0

import java.util.HashMap;

/**
 * 解题思路：
 * 滑动窗口
 * 当遇到重复的元素时候，左指针就向下推一位
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

//            int n = s.length(), ans = 0;
//            HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
//            for (int end = 0, start = 0; end < n; end++) {
//                char charAt = s.charAt(end);
//                if (hashMap.containsKey(charAt)) {
//                    start = Math.max(hashMap.get(charAt), start);
//                }
//                ans = Math.max(ans, end - start + 1);
//                hashMap.put(s.charAt(end), end + 1);
//            }
//            return ans;

//            if (s.length() == 0) {
//                return 0;
//            }
//
//            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//            int max = 0;
//            int left = 0;
//            for (int i = 0; i < s.length(); i++) {
//                if (map.containsKey(s.charAt(i))) {
//                    left = Math.max(left, map.get(s.charAt(i)) + 1);
//                }
//                map.put(s.charAt(i), i);
//                max = Math.max(max, i - left + 1);
//            }

//            HashMap<Character, Integer> hashMap = new HashMap<>();
//            int left = 0;
//            int max = 0;
//            for (int i = 0; i < s.length(); i++) {
//                if (hashMap.containsKey(s.charAt(i))) {
//                    left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
//                }
//                hashMap.put(s.charAt(i), i);
//                max = Math.max(max, i - left + 1);
//            }
//            return max;

            HashMap<Character, Integer> hashMap = new HashMap<>();
            int left = 0;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                if (hashMap.containsKey(s.charAt(i))) {
                    left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
                }
                hashMap.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;

//            int res = 0;
//            HashMap<Character, Integer> window = new HashMap<>();
//            int left = 0, right = 0;
//            while (right < s.length()) {
//                char c = s.charAt(right);
//                right++;
//                window.put(c, window.getOrDefault(c, 0) + 1);
//                while (window.get(c) > 1) {
//                    char d = s.charAt(left);
//                    left++;
//                    if (window.containsKey(d)) {
//                        window.put(d, window.getOrDefault(d, 0) - 1);
//                    }
//                }
//                res = Math.max(res, right - left);
//            }
//            return res;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int sssba = solution.lengthOfLongestSubstring("sssba");
//            System.out.println(sssba);
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
