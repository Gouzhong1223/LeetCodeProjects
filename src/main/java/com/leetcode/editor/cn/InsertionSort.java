package com.leetcode.editor.cn;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-12-05 16:13
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.leetcode.editor.cn
 * @ProjectName : LeetCodeProjects
 * @Version : 1.0.0
 */
public class InsertionSort {
    public void insertionSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int current;

        for (int i = 0; i < nums.length - 1; i++) {
            int preIndex = i;
            current = nums[i + 1];
            while (preIndex >= 0 && current < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        int[] ints = {4, 2, 6, 7, 4, 8, 9, 8, 1, 2};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println(System.currentTimeMillis());
    }
}
