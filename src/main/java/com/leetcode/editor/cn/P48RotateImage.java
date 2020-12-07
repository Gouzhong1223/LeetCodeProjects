package com.leetcode.editor.cn;
//给定一个 n × n 的二维矩阵表示一个图像。
//
// 将图像顺时针旋转 90 度。
//
// 说明：
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
// 示例 1:
//
// 给定 matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//
//
// 示例 2:
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
//
// Related Topics 数组
// 👍 650 👎 0

public class P48RotateImage {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
            先沿右上 - 左下的对角线翻转（270° +270°+ 一次镜像），再沿水平中线上下翻转（-180° +−180°+ 一次镜像），可以实现顺时针 9090 度的旋转效果
         */
        public void rotate(int[][] matrix) {
            if (matrix.length == 0 || matrix.length != matrix[0].length) {
                return;
            }
            int length = matrix.length;
            // 先完成对角线交换
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[length - 1 - j][length - 1 - i];
                    matrix[length - 1 - j][length - 1 - i] = temp;
                }
            }
            for (int i = 0; i < (length >> 1); i++) {
                for (int j = 0; j < length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[length - 1 - i][j];
                    matrix[length - 1 - i][j] = temp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
