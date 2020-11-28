package com.leetcode.editor.cn;
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//
//
// 示例:
//
// 输入: [1,2,3,0,2]
//输出: 3
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
// Related Topics 动态规划
// 👍 613 👎 0

public class P309BestTimeToBuyAndSellStockWithCooldown {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0;
            int dp_i_1 = Integer.MIN_VALUE;
            int dp_pre_0 = 0;
            for (int price : prices) {
                int tmp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
                dp_i_1 = Math.max(dp_i_1, dp_pre_0 - price);
                dp_pre_0 = tmp;
            }
            return dp_i_0;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] prises = {1, 2, 3, 0, 2};
//            System.out.println(solution.maxProfit(prises));
//
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
