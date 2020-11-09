package com.leetcode.editor.cn;
//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//
// （这里，平面上两点之间的距离是欧几里德距离。）
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
//
//
//
// 示例 1：
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释：
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
//
//
// 示例 2：
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
//
//
//
//
// 提示：
//
//
// 1 <= K <= points.length <= 10000
// -10000 < points[i][0] < 10000
// -10000 < points[i][1] < 10000
//
// Related Topics 堆 排序 分治算法
// 👍 188 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P973KClosestPointsToOrigin {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] point1, int[] point2) {
                    return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
                }
            });
            return Arrays.copyOfRange(points, 0, K);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
