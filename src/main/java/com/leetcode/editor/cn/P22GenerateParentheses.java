package com.leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1355 👎 0

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> ans = new ArrayList<>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        /**
         * @param ans   结果集
         * @param cur   需要拼装的字符串
         * @param open  已经使用的左括号数量
         * @param close 已经使用的右括号数量
         * @param max   需要生成的括号对数
         */
        private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            // 判断已经生成的字符串长度是否已经是 2n，如果是，则说明括号已经生成完毕，直接返回
            // 相当于终止条件
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            // 如果左括号小于 n，则说明可以往左边继续添加左括号
            if (open < max) {
                cur.append('(');
                // 添加完成之后开始进行递归，这里就是把左括号的数量加一再调用 backtrack 方法进行下一步字符串拼装
                backtrack(ans, cur, open + 1, close, max);
                // 回退到调用递归之前的状态
                cur.deleteCharAt(cur.length() - 1);
            }

            // 右括号数量小于左括号，则说明现在可以往里面添加右括号
            if (close < open) {
                // 和上面同理
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                // 回退到调用递归之前的状态
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
