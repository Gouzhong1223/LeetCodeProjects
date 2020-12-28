package com.leetcode.editor.cn;
//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
// 示例 1:
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
//
//
// 示例 2:
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
//
// Related Topics 数组
// 👍 563 👎 0

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix.length == 0 || matrix[0].length == 0) {
                return res;
            }
            int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
            while (true) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                if (++top > bottom) {
                    break;
                }
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                if (--right < left) {
                    break;
                }
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                if (--bottom < top) {
                    break;
                }
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                if (++left > right) {
                    break;
                }
            }
            //            if (matrix.length == 0) {
//                return res;
//            }
//            int m = matrix.length;
//            int n = matrix[0].length;
//            int i = 0;
//            int count = (Math.min(m, n) + 1) / 2;
//            while (i < count) {
//                for (int j = i; j < n - i; j++) {
//                    res.add(matrix[i][j]);
//                }
//                for (int j = i + 1; j < m - i; j++) {
//                    res.add(matrix[j][(n - 1) - i]);
//                }
//                for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--) {
//                    res.add(matrix[m - 1 - i][j]);
//                }
//                for (int j = (m - 1) - (i + 1); j >= i + 1 && ((n - 1 - i) != i); j--) {
//                    res.add(matrix[j][i]);
//                }
//                i++;
//            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
