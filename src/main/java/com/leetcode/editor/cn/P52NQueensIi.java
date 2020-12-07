package com.leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
//
// 示例:
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
//
//
//
// 提示：
//
//
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ）
//
// Related Topics 回溯算法
// 👍 213 👎 0

import java.util.HashSet;

public class P52NQueensIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;

        public int totalNQueens(int n) {
            HashSet<Integer> pie = new HashSet<>();
            HashSet<Integer> na = new HashSet<>();
            HashSet<Integer> shu = new HashSet<>();
            dfs(n, pie, na, shu, 0);
            return res;
        }

        private void dfs(int n, HashSet<Integer> pie, HashSet<Integer> na, HashSet<Integer> shu, int row) {
            if (row == n) {
                res += 1;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (pie.contains(i - row) || na.contains(i + row) || shu.contains(i)) {
                    continue;
                }
                pie.add(i - row);
                na.add(i + row);
                shu.add(i);
                dfs(n, pie, na, shu, row + 1);
                pie.remove(i - row);
                na.remove(i + row);
                shu.remove(i);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
