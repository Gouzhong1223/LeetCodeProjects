package com.leetcode.editor.cn;
//给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
//
// 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
//
// 请你返回排序后的数组。
//
//
//
// 示例 1：
//
// 输入：arr = [0,1,2,3,4,5,6,7,8]
//输出：[0,1,2,4,8,3,5,6,7]
//解释：[0] 是唯一一个有 0 个 1 的数。
//[1,2,4,8] 都有 1 个 1 。
//[3,5,6] 有 2 个 1 。
//[7] 有 3 个 1 。
//按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
//
//
// 示例 2：
//
// 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
//输出：[1,2,4,8,16,32,64,128,256,512,1024]
//解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
//
//
// 示例 3：
//
// 输入：arr = [10000,10000]
//输出：[10000,10000]
//
//
// 示例 4：
//
// 输入：arr = [2,3,5,7,11,13,17,19]
//输出：[2,3,5,17,7,11,13,19]
//
//
// 示例 5：
//
// 输入：arr = [10,100,1000,10000]
//输出：[10,100,10000,1000]
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 500
// 0 <= arr[i] <= 10^4
//
// Related Topics 排序 位运算
// 👍 47 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P1356SortIntegersByTheNumberOf1Bits {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortByBits(int[] arr) {
            final int[] bit = new int[10001];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : arr) {
                // 将数组中的元素先映射到集合
                list.add(i);
                // 将数组中的元素分别计算出对应二进制数包含的 1 的个数，将其装载在 bit 中，其中，bit 的索引为元素真正的值
                bit[i] = get(i);
            }
            // 排序
            Collections.sort(list, new Comparator<Integer>() {
                // 构建排序条件
                @Override
                public int compare(Integer x, Integer y) {
                    // 如果 x 对应的二进制数包含的 1 的个数和 y 对应的二进制数包含的 1 的个数不相等，则直接做差
                    // 由于是升序，所以当 x 对应二进制数包含的 1 的个数小于 y 对应的二进制数包含的 1 的个数的时候，x 就因该在 y 的前面
                    // 如果是降序排列，则相反
                    if (bit[x] != bit[y]) {
                        return bit[x] - bit[y];
                    } else {
                        // x 的 1 的个数和 y 相等，则直接比较 x 和 y 的值
                        return x - y;
                    }
                }
            });

            // 将已经排序好的集合填充到数组
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(i);
            }
            return arr;
        }

        /**
         * 计算一个二进制数里面 1 的个数
         *
         * @param x 需要计算的数字
         * @return 数字对应的二进制数包含的 1 的个数
         */
        public int get(int x) {
            int res = 0;
            while (x != 0) {
                res += x % 2;
                x /= 2;
            }
            return res;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] ints = {2, 3, 4, 6, 7, 5, 5};
//            int[] sortByts = solution.sortByBits(ints);
//            for (int sortByt : sortByts) {
//                System.out.println(sortByt);
//            }
//            System.out.println(solution.get(15));
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
