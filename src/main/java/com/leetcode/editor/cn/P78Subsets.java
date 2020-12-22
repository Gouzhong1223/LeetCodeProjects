package com.leetcode.editor.cn;
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法
// 👍 920 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P78Subsets {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            backTrack(0, nums, path, res);
            res.add(new ArrayList<>());
            return res;
        }

        public void backTrack(int i, int[] nums, LinkedList<Integer> path, List<List<Integer>> res) {
            if (path.size() > nums.length) {
                return;
            }
            if (path.size() >= 1 && path.size() <= nums.length) {
                res.add(new LinkedList<>(path));
            }
            for (int j = i; j < nums.length; j++) {
                if (path.contains(nums[j])) {
                    continue;
                }
                path.addLast(nums[j]);
                backTrack(j + 1, nums, path, res);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
