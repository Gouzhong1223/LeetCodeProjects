package com.leetcode.editor.cn;
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 示例 1:
//
// 输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//
// 示例 2:
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
// Related Topics 广度优先搜索 数学 动态规划
// 👍 719 👎 0

public class P279PerfectSquares {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                for (int j = 1; i - j * j >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
