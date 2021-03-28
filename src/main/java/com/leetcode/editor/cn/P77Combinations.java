package com.leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 533 👎 0

import java.util.*;

public class P77Combinations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }
            Deque<Integer> queue = new ArrayDeque<>();
            backTrack(res, queue, k, 1, n);
            return res;
        }

        void backTrack(List<List<Integer>> res, Deque<Integer> path, int k, int begin, int n) {
            if (path.size() == k) {
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = begin; i <= n; i++) {
                if (path.contains(i)) {
                    continue;
                }
                path.addLast(i);
                backTrack(res, path, k, i, n);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
