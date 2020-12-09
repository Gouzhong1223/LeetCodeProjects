package com.leetcode.editor.cn;
//返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
//
// 如果没有和至少为 K 的非空子数组，返回 -1 。
//
//
//
//
//
//
// 示例 1：
//
// 输入：A = [1], K = 1
//输出：1
//
//
// 示例 2：
//
// 输入：A = [1,2], K = 4
//输出：-1
//
//
// 示例 3：
//
// 输入：A = [2,-1,2], K = 3
//输出：3
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 50000
// -10 ^ 5 <= A[i] <= 10 ^ 5
// 1 <= K <= 10 ^ 9
//
// Related Topics 队列 二分查找
// 👍 233 👎 0

import java.util.HashMap;

public class P862ShortestSubarrayWithSumAtLeastK {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] A, int K) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(1, 1);
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
