package com.leetcode.editor.cn;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
// Related Topics 数组 二分查找 分治算法
// 👍 3296 👎 0

import java.util.ArrayList;
import java.util.Comparator;

public class P4MedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] int1 = {1, 2};
            int[] int2 = {3, 4};
            double medianSortedArrays = solution.findMedianSortedArrays(int1, int2);
            System.out.println(medianSortedArrays);
        }

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            ArrayList<Integer> integers = new ArrayList<>();

            for (int i : nums1) {
                integers.add(i);
            }
            for (int i : nums2) {
                integers.add(i);
            }
            integers.sort(Comparator.comparingInt(o -> o));
            double res;
            int size = integers.size();
            if (integers.size() % 2 == 0) {
                // 1 3 4 6
                res = (integers.get(size / 2 - 1) + integers.get((size / 2))) / 2;
            } else {
                // 0 1 2 3 4
                res = integers.get((size - 1) / 2);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
