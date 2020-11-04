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

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P20ValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public boolean isValid(String s) {
//            // 如果s的长度等于奇数，则直接返回 false
//            if (s.length() % 2 != 0) {
//                return false;
//            }
//            Stack<Character> stack = new Stack<>();
//            for (char c : s.toCharArray()) {
//                if (c == '(') {
//                    stack.push(')');
//                } else if (c == '{') {
//                    stack.push('}');
//                } else if (c == '[') {
//                    stack.push(']');
//                    /**
//                     * 到这个判断的时候，就说明以上三种情况都不匹配，这时候，就要在栈里面寻找当前字符的相反字符
//                     * 因为左括号必须以正确的顺序闭合，所以，当 s 是一个符合条件的字符串的时候，就应该 pop 出一个和当前字符正好相反的字符
//                     * 如果不是，或者栈为空，则说明 s 可能不是以正确的形式闭合或者不是闭合类型的字符串
//                     */
//                } else if (stack.empty() || c != stack.pop()) {
//                    return false;
//                }
//            }
//            return stack.empty();
//        }


        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }
            // 将右括号作为键，左括号作为值，保存在 Map 里面
            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                // 判断拿到的字符是否是右括号类型
                if (pairs.containsKey(ch)) {
                    // 当拿到的是右括号类型，先判断队列是否为空，如果为空，则直接返回 False
                    // 如果不为空，则判断队列弹出的元素和当前右括号所对应的左括号是否相等，如果不相等，则说明括号不能闭合，直接返回 False
                    if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                        return false;
                    }
                    // 这里说明当前栈弹出的元素和 ch 所对应的左括号对应，直接弹出
                    stack.pop();
                } else {
                    // 如果不是右括号类型，说明为左括号类型，直接压栈，以便后面使用
                    stack.push(ch);
                }
            }
            // 经过上面的循环，如果栈元素全部弹出，则说明括号可以闭合，如果不为空，则说明括号没有完全闭合
            return stack.isEmpty();
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}
