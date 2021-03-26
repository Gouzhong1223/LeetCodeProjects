package com.leetcode.editor.cn;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 回溯算法
// 👍 645 👎 0

import java.util.*;

public class P47PermutationsIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            Arrays.sort(nums);
            boolean[] used = new boolean[len];
            Deque<Integer> path = new ArrayDeque<>(len);
            backTrack(nums, len, 0, used, path, res);
            return res;
        }

        private void backTrack(int[] nums, int length, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
            if (depth == length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                backTrack(nums, length, depth + 1, used, path, res);
                used[i] = false;
                path.removeLast();
            }

        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] ints = {1, 1, 2};
//            List<List<Integer>> lists = solution.permuteUnique(ints);
//            for (List<Integer> list : lists) {
//                System.out.println(list);
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
