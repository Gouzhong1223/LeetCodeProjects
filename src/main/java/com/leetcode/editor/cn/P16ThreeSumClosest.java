package com.leetcode.editor.cn;
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针
// 👍 619 👎 0

import java.util.Arrays;

public class P16ThreeSumClosest {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            // 排序
            Arrays.sort(nums);
            // 初始化一个和
            int ans = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length; i++) {
                // 定义左右指针
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    // 计算左右指针以及当前指针的和
                    int sum = nums[start] + nums[end] + nums[i];
                    // 把当前计算出来的和拿来和 ans 作比较
                    if (Math.abs(target - sum) < Math.abs(target - ans)) {
                        // 说明最新的和更接近 target，替换原来的 ans
                        ans = sum;
                    }
                    if (sum > target) {
                        // 如果当前的和大于 target，则右指针向左推进
                        end--;
                    } else if (sum < target) {
                        // 如果当前的和小于 target，则左指针向右推进
                        start++;
                    } else {
                        // 这里就说明当前计算出来的和刚好等于 target，直接返回
                        return ans;
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
