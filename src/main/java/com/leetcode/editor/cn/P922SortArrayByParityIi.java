package com.leetcode.editor.cn;
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//
// 你可以返回任何满足上述条件的数组作为答案。
//
//
//
// 示例：
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
//
//
//
//
// 提示：
//
//
// 2 <= A.length <= 20000
// A.length % 2 == 0
// 0 <= A[i] <= 1000
//
//
//
// Related Topics 排序 数组
// 👍 161 👎 0

public class P922SortArrayByParityIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            // 双指针,原地修改
            int j = 1;
            for (int i = 0; i < A.length; i += 2) {
                if (A[i] % 2 == 1) {
                    while (A[j] % 2 == 1) {
                        j += 2;
                    }
                    swap(A, i, j);
                }
            }
            return A;

        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] ints = solution.sortArrayByParityII(new int[]{4, 2, 5, 6, 7, 8});
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }

        /**
         * 交换数组中指定下标的两个元素
         *
         * @param A 目标数组
         * @param i 需要置换的元素下标1
         * @param j 需要置换的元素小标2
         */
        private void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

// 遍历两次-->分别将奇数偶数填充
//            执行耗时:4 ms,击败了32.25% 的Java用户
//            内存消耗:41.1 MB,击败了40.04% 的Java用户
//            int i = 0;
//            for (int i1 : A) {
//                if (i1 % 2 == 0) {
//                    res[i] = i1;
//                    i += 2;
//                }
//            }
//            int j = 1;
//            for (int i1 : A) {
//                if (i1 % 2 == 1) {
//                    res[j] = i1;
//                    j += 2;
//                }
//            }

// 暴力法---->放弃
//          执行耗时:6 ms,击败了14.04% 的Java用户
//			内存消耗:42.8 MB,击败了5.05% 的Java用户
//            // 放奇数
//            ArrayList<Integer> a = new ArrayList<>(A.length / 2);
//            // 放偶数
//            ArrayList<Integer> b = new ArrayList<>(A.length / 2);
//            for (int i : A) {
//                if (i % 2 != 0) {
//                    // 奇数添加到 a
//                    a.add(i);
//                } else {
//                    // 偶数添加到 b
//                    b.add(i);
//                }
//            }
//            int j = 0;
//            int o = 0;
//            int[] res = new int[A.length];
//            for (int i = 0; i < res.length; i++) {
//                if (i % 2 == 0) {
//                    res[i] = b.get(o++);
//                } else {
//                    res[i] = a.get(j++);
//                }
//            }
//            return res;

    }
//leetcode submit region end(Prohibit modification and deletion)

}
