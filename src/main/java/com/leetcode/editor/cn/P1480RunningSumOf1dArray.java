package com.leetcode.editor.cn;
//给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
//
// 请返回 nums 的动态和。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,6,10]
//解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
//
// 示例 2：
//
// 输入：nums = [1,1,1,1,1]
//输出：[1,2,3,4,5]
//解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
//
// 示例 3：
//
// 输入：nums = [3,1,2,10,1]
//输出：[3,4,6,16,17]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// -10^6 <= nums[i] <= 10^6
//
// Related Topics 数组 前缀和 👍 106 👎 0

public class P1480RunningSumOf1dArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] runningSum(int[] nums) {
            // 如果数组长度为 1 就直接返回
            if (nums.length == 1 || nums == null) {
                return nums;
            }
            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i - 1] + nums[i];
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
