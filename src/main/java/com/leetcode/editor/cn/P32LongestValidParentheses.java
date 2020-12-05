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
            if (s.length() == 0 || s == null) {
                return 0;
            }
            int res = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
            return res;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.longestValidParentheses("))()(())"));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
