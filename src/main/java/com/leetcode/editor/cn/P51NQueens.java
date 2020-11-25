package com.leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例：
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]dsad
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//
//
//
// 提示：
//
//
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
// Related Topics 回溯算法
// 👍 676 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P51NQueens {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            HashSet<Integer> pie = new HashSet<>(n);
            HashSet<Integer> na = new HashSet<>(n);
            HashSet<Integer> shu = new HashSet<>(n);
            int[][] queens = new int[n][n];
            dfs(n, pie, na, 0, queens, shu);
            return res;

        }

        public void dfs(int n, HashSet<Integer> pie, HashSet<Integer> na, int row, int[][] queens, HashSet<Integer> shu) {
            // 判断是都达到终止条件
            if (row == queens.length) {
                // 将当前结果接入结果集
                res.add(generate(queens));
                // 返回
                return;
            }

            // 开始循环列
            for (int i = 0; i < n; i++) {
                // 判断撇捺是否已经有皇后
                // 判断当前列是否有皇后
                if (na.contains(i - row) || pie.contains(i + row) || shu.contains(i)) {
                    // 说明当前位置不允许放皇后
                    continue;
                }
                // 允许放皇后
                queens[row][i] = 1;
                pie.add(i + row);
                na.add(i - row);
                shu.add(i);
                dfs(n, pie, na, row + 1, queens, shu);
                queens[row][i] = 0;
                shu.remove(i);
                na.remove(i - row);
                pie.remove(i + row);

            }

        }

        public ArrayList<String> generate(int[][] queens) {
            ArrayList<String> resStr = new ArrayList<>();
            for (int[] queen : queens) {
                StringBuilder s = new StringBuilder();
                for (int i : queen) {
                    if (i == 0) {
                        s.append(".");
                    } else {
                        s.append("Q");
                    }
                }
                resStr.add(s.toString());
            }
            return resStr;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}
