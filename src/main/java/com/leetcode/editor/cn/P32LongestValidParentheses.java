package com.leetcode.editor.cn;
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划
// 👍 1086 👎 0

import java.util.Stack;

public class P32LongestValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int longestValidParentheses(String s) {
            // 最大数量
            int max = 0;
            // 标识下一次需不需要重新计数
            boolean b = false;
            Stack<Character> characters = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (characters.isEmpty() && c == ')') {
                    characters.push(c);
                    // 下一次需要重新开始计数
                    b = true;
                    continue;
                }
                if (c == ')') {
                    if (characters.peek() == '(') {
                        characters.pop();
                        if (b) {
                            max = 2;
                        } else {
                            max += 2;
                        }
                        if (characters.isEmpty()) {
                            b = false;
                        } else {
                            b = characters.peek() != '(';
                        }
                    }
                } else {
                    if (characters.isEmpty()) {
                        b = false;
                    } else {
                        b = characters.peek() == '(';
                    }
                    characters.push(c);
                }
            }
            return max;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.longestValidParentheses("()(())"));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
