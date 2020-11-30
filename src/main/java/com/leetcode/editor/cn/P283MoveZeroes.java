package com.leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 761 👎 0

public class P283MoveZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] ints = {0, 1, 0, 3, 12};
            solution.moveZeroes(ints);

        }

        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }
            for (int i = j; i < nums.length; ++i) {
                nums[i] = 0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
