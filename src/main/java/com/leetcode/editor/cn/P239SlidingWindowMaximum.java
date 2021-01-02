package com.leetcode.editor.cn;
//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。
//
//
//
// 进阶：
//
// 你能在线性时间复杂度内解决此题吗？
//
//
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 663 👎 0

import java.util.LinkedList;

public class P239SlidingWindowMaximum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < 2) {
                return nums;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
                if (queue.peek() <= i - k) {
                    queue.poll();
                }
                if (i + 1 >= k) {
                    res[i + 1 - k] = nums[queue.peek()];
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
