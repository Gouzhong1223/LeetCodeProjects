package com.leetcode.editor.cn;
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
//输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
//
//输入：coins = [1], amount = 0
//输出：0
//
//
// 示例 4：
//
//
//输入：coins = [1], amount = 1
//输出：1
//
//
// 示例 5：
//
//
//输入：coins = [1], amount = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 932 👎 0

public class P322CoinChange {
    //leetcode submit region begin(Prohibit modification and deletion)
     class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            return dp(coins, amount, new int[amount]);
        }

        public int dp(int[] coins, int amount, int[] amounts) {
            if (amount < 0) {
                return -1;
            }
            if (amount == 0) {
                return 0;
            }
            if (amounts[amount - 1] != 0) {
                return amounts[amount - 1];
            }

            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int resutlt = dp(coins, amount - coin, amounts);
                if (resutlt >= 0 && resutlt < min) {
                    min = 1 + resutlt;
                }
                amounts[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            }
            return amounts[amount - 1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
