package com.leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109
//
// Related Topics 数组 二分查找
// 👍 732 👎 0

public class P34FindFirstAndLastPositionOfElementInSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
//            if (nums.length == 1 && target == nums[0]) {
//                return new int[]{0, 0};
//            }
            int j;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    j = i;
                    while (nums[j] == nums[i]) {
                        j++;
                        if (j == nums.length) {
                            break;
                        }
                    }
                    return new int[]{i, j - 1};
                }
            }
            return new int[]{-1, -1};
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] ints = {2, 2};
//            System.out.println(solution.searchRange(ints, 2));
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
