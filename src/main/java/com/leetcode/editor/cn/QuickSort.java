package com.leetcode.editor.cn;

import java.util.ArrayList;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-12-05 14:58
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.leetcode.editor.cn
 * @ProjectName : LeetCodeProjects
 * @Version : 1.0.0
 */
public class QuickSort {

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k >= input.length) {
            for (int i : input) {
                res.add(i);
            }
            return res;
        }
        sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public void quickSort(int[] nums, int low, int high) {
        int i, j, p, temp;
        if (low >= high) {
            return;
        }
        p = nums[low];
        i = low;
        j = high;
        while (i < j) {
            while (nums[j] >= p && i < j) {
                j--;
            }
            while (nums[i] <= p && i < j) {
                i++;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[low] = nums[i];
        nums[i] = p;
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);

    }


    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
        int[] ints = {4, 5, 1, 6, 2, 7, 3, 8};
        QuickSort quickSort = new QuickSort();
        ArrayList<Integer> integers = quickSort.GetLeastNumbers_Solution(ints, 8);
        integers.forEach(System.out::println);
    }
}
