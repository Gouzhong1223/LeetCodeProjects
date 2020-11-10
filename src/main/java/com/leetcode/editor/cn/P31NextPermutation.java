package com.leetcode.editor.cn;
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须原地修改，只允许使用额外常数空间。
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
// Related Topics 数组
// 👍 727 👎 0

public class P31NextPermutation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            // 找出第一个指针，满足 nums[k]>nums[k+1]
            int firstIndex = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    firstIndex = i;
                    break;
                }
            }
            // 若没有找到 k 指针,则说明数组为降序数组，此时将数组进行翻转-->升序
            if (firstIndex == -1) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
            int secondIndex = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[firstIndex]) {
                    secondIndex = i;
                    break;
                }
            }
            swap(nums, firstIndex, secondIndex);
            reverse(nums, firstIndex + 1, nums.length - 1);
        }

        /**
         * 翻转数组中从 i->j 之间的元素
         *
         * @param nums 被翻转的数组
         * @param i    左指针
         * @param j    右指针
         */
        private void reverse(int[] nums, int i, int j) {
            // 左右指针不断往中间夹逼，完成交换的步骤
            while (i < j) {
                swap(nums, i++, j--);
            }
        }

        /**
         * 交换数组中指定下标的两个元素
         *
         * @param nums 被交换的数组
         * @param i    需要交换的元素 1
         * @param i1   需要交换的元素 2
         */
        private void swap(int[] nums, int i, int i1) {
            int tmp = nums[i];
            nums[i] = nums[i1];
            nums[i1] = tmp;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
