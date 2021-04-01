package com.leetcode.editor.cn;
//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 :
//
//
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
//
//
// 说明 :
//
//
// 数组的长度为 [1, 20,000]。
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
//
// Related Topics 数组 哈希表
// 👍 836 👎 0

public class P560SubarraySumEqualsK {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int len = nums.length;
            int[] preSum = new int[len + 1];
            preSum[0] = 0;
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            int count = 0;
            for (int left = 0; left < len; left++) {
                for (int right = left; right < len; right++) {
                    // 区间和 [left..right]，注意下标偏移
                    if (preSum[right + 1] - preSum[left] == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
