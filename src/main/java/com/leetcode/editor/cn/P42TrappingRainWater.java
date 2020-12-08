package com.leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针
// 👍 1839 👎 0

public class P42TrappingRainWater {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            int length = height.length;
            int res = 0;
            int[] leftMaxs = new int[length];
            int[] rightMaxs = new int[length];
            leftMaxs[0] = height[0];
            rightMaxs[length - 1] = height[length - 1];

            for (int i = 1; i < length - 1; i++) {
                leftMaxs[i] = Math.max(height[i], leftMaxs[i - 1]);
            }
            for (int i = length - 2; i >= 0; i--) {
                rightMaxs[i] = Math.max(height[i], rightMaxs[i + 1]);
            }
            for (int i = 1; i < length - 1; i++) {
                // 当前柱子能接的最多的水就是左右节点最高柱子中最爱的柱子减去当前柱子的高度
                res += Math.min(leftMaxs[i], rightMaxs[i]) - height[i];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
