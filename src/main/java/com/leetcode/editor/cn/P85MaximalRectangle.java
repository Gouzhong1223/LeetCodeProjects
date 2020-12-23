package com.leetcode.editor.cn;
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
//
//
// 示例 2：
//
//
//输入：matrix = []
//输出：0
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
// 示例 4：
//
//
//输入：matrix = [["1"]]
//输出：1
//
//
// 示例 5：
//
//
//输入：matrix = [["0","0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// rows == matrix.length
// cols == matrix[0].length
// 0 <= row, cols <= 200
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 栈 数组 哈希表 动态规划
// 👍 677 👎 0

public class P85MaximalRectangle {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int length = matrix.length;
            if (length == 0) {
                return 0;
            }
            int res = 0;
            int[] heights = new int[matrix[0].length];
            for (char[] chars : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (chars[j] == '1') {
                        heights[j]++;
                    } else {
                        heights[j] = 0;
                    }
                }
                res = Math.max(res, largestRectangleArea(heights));
            }
            return res;
        }

        public int largestRectangleArea(int[] heights) {
            int length = heights.length;
            int res = 0;
            for (int i = 0; i < length; i++) {
                int w = 1, j = i, h = heights[i];
                while (--j >= 0 && heights[j] >= h) {
                    w++;
                }
                j = i;
                while (++j < length && heights[j] >= h) {
                    w++;
                }
                res = Math.max(res, h * w);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
