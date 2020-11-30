package com.leetcode.editor.cn;
//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//
//
// 示例 1：
//
//
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//
// 示例 2：
//
//
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3
//。
//
//
//
// 提示：
//
//
// 0 <= k <= 109
// 0 <= prices.length <= 1000
// 0 <= prices[i] <= 1000
//
// Related Topics 动态规划
// 👍 329 👎 0

public class P188BestTimeToBuyAndSellStockIv {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] prises = {3, 2, 6, 5, 0, 3};
            System.out.println(solution.maxProfit(2, prises));
        }

        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if (k > n / 2) {
                int[][] dp = new int[n][2];
                for (int i = 0; i < n; i++) {
                    if (i == 0) {
                        dp[0][0] = 0;
                        dp[0][1] = -prices[0];
                        continue;
                    }
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                }
                return dp[n - 1][0];
            }
            int[][][] dp = new int[n][k + 1][2];
            for (int i = 0; i < n; i++) {
                for (int j = k; j >= 1; j--) {
                    if (i - 1 == -1) {
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[0];
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][k][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
