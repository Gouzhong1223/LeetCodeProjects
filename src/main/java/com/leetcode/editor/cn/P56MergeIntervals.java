package com.leetcode.editor.cn;
//给出一个区间的集合，请合并所有重叠的区间。
//
//
//
// 示例 1:
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//
//
// 提示：
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics 排序 数组
// 👍 721 👎 0

import java.util.Arrays;
import java.util.Comparator;

public class P56MergeIntervals {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
            int[][] res = new int[intervals.length][2];
            int index = -1;
            for (int[] interval : intervals) {
                // 不重叠
                if (index == -1 || interval[0] > res[index][1]) {
                    res[++index] = interval;
                } else {
                    // 重叠
                    res[index][1] = Math.max(res[index][1], interval[1]);
                }
            }
            return Arrays.copyOf(res, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
