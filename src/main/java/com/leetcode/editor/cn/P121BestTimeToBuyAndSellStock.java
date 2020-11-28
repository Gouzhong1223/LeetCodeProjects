package com.leetcode.editor.cn;
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
// 注意：你不能在买入股票前卖出股票。
//
//
//
// 示例 1:
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2:
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
// Related Topics 数组 动态规划
// 👍 1317 👎 0

public class P121BestTimeToBuyAndSellStock {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int maxProfit(int[] prices) {

            if (prices.length == 0) {
                return 0;
            }
            // 1 表示持有股票 ; 0 表示未持有股票
            /*
            dp[0][1] = 0
            dp[n][0] = max(dp[n-1][0],dp[n-1][1]+prises[n])
            dp[n][1] = max(dp[n-1][1],dp[n-1][0]-prises[n]) = max(dp[n-1][0],-prises[n])
             */
            int n = prices.length;
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                if (i - 1 == -1) {
                    // 第 0 天的情况
                    /*
                    dp[0][0] = 0 // 第 0 天没有持有股票的情况
                    dp[0][1] = -prices[i] // 第 0 天持有股票的情况
                     */
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }

            return dp[n - 1][0];
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] prises = {7, 1, 5, 3, 6, 4};
            System.out.println(solution.maxProfit(prises));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
