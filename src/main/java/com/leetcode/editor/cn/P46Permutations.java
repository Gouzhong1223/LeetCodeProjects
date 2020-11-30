package com.leetcode.editor.cn;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1014 👎 0

import java.util.LinkedList;
import java.util.List;

public class P46Permutations {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {

        List<List<Integer>> res = new LinkedList<>();

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] ints = {1, 2, 3};
            List<List<Integer>> permute = solution.permute(ints);
            permute.forEach(System.out::println);
        }

        public List<List<Integer>> permute(int[] nums) {
            // 构造装载已经做出的选择的容器
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }

        public void backtrack(int[] nums, LinkedList<Integer> track) {
            // 判断是否满足退出条件
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int num : nums) {
                // 判断当前选择是否合法
                if (track.contains(num)) {
                    continue;
                }
                // 符合选择条件
                track.add(num);
                backtrack(nums, track);
                // 移除当前选择条件
                track.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
