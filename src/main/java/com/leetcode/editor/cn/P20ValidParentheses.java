package com.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1953 👎 0

import java.util.Stack;

public class P20ValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            // 如果s的长度等于奇数，则直接返回 false
            if (s.length() % 2 != 0) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                    /**
                     * 到这个判断的时候，就说明以上三种情况都不匹配，这时候，就要在栈里面寻找当前字符的相反字符
                     * 因为左括号必须以正确的顺序闭合，所以，当 s 是一个符合条件的字符串的时候，就应该 pop 出一个和当前字符正好相反的字符
                     * 如果不是，或者栈为空，则说明 s 可能不是以正确的形式闭合或者不是闭合类型的字符串
                     */
                } else if (stack.empty() || c != stack.pop()) {
                    return false;
                }
            }
            return stack.empty();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
