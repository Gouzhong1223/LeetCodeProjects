package com.leetcode.editor.cn;
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Related Topics 数组 回溯算法
// 👍 424 👎 0


import java.util.*;

public class P90SubsetsIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            Arrays.sort(nums);
            Deque<Integer> path = new ArrayDeque<>();
            backTrack(res, nums, 0, path);
            return res;
        }

        private void backTrack(List<List<Integer>> res, int[] nums, int start, Deque<Integer> path) {
            res.add(new ArrayList<>(path));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                path.addLast(nums[i]);
                backTrack(res, nums, i + 1, path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
