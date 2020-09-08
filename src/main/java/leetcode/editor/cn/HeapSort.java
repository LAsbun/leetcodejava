package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Created by sws
 */

public class HeapSort {

    public static void heapSort(int[] nums) {

        buildHeap(nums, nums.length - 1);
        int k = nums.length - 1;
        while (k > 1) {
            swap(nums, 1, k);
            heapify(nums, k, 1);
        }

    }

    private static void buildHeap(int[] nums, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(nums, n, i);
        }
    }

    private static void heapify(int[] nums, int n, int i) {
        while (true) {
            int maxpos = i;
            if (i * 2 <= n && nums[maxpos] < nums[i * 2]) maxpos = i * 2;
            if (i * 2 + 1 <= n && nums[maxpos] < nums[i * 2 + 1]) maxpos = i * 2 + 1;
            if (maxpos == i) break;
            swap(nums, maxpos, i);
            i = maxpos;
        }
    }

    private static void swap(int[] nums, int maxpos, int i) {
        int tmp = nums[maxpos];
        nums[maxpos] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 3, 4, 2, 1, 5, 6, 7, 8};
        heapSort(array);
        System.out.println(Arrays.toString(array));

    }
}
