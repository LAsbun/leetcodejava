package leetcode.editor.cn;

import java.util.Arrays;

public class AllSort {

    /**
     * 每次只比较相邻的两个，循环n-1次即可搞定
     *
     * @param nums
     * @param length
     */
    public static void bubbleSort(int[] nums, int length) {
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                // 从小到大
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 分排序与未排序，每次都从未排序中找一个插入排序的区间内
     *
     * @param nums
     * @param length
     */
    public static void insertSort(int[] nums, int length) {
        for (int i = 1; i < length; i++) {
            int tmp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 从小到大
                if (nums[j] > tmp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = tmp;
        }
    }

    /**
     * 插入排序，每次找到最大的那个，放入最后面
     *
     * @param nums
     * @param length
     */
    public static void selectSort(int[] nums, int length) {

        // 要找n-1次
        for (int i = 0; i < length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < length; j++) {
                // 从小到大
                if (nums[max] > nums[j]) {
                    max = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
        }
    }

    /**
     * 归并排序。将数组分为两段，各自段顺序之后，再进行合并。
     *
     * @param nums
     * @param n
     */
    public static void mergeSort(int[] nums, int n) {

        mergepartSort(nums, 0, n - 1);
    }

    private static void mergepartSort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergepartSort(nums, start, mid);
        mergepartSort(nums, mid + 1, end);

        merge(nums, start, mid, end);


    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                tmp[index++] = nums[j++];

            } else {
                tmp[index++] = nums[i++];
            }
        }

        while (i <= mid) {
            tmp[index++] = nums[i++];
        }
        while (j <= end) {
            tmp[index++] = nums[j++];
        }

        for (int k = 0; k < tmp.length; k++) {
            nums[start + k] = tmp[k];
        }
    }

    /**
     * 先拆分，然后再进行排序。
     * @param nums
     * @param length
     */
    public static void fastSort(int[] nums, int length) {
        fastpartSort(nums, 0, length - 1);
    }

    private static void fastpartSort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int fastpatition = fastpatition(nums, start, end);
        fastpartSort(nums, start, fastpatition - 1);
        fastpartSort(nums, fastpatition + 1, end);

    }

    private static int fastpatition(int[] nums, int start, int end) {
        int mm = nums[end];
        int cur = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < mm) {
                int tmp = nums[i];
                nums[i] = nums[cur];
                nums[cur] = tmp;
                cur++;
            }
        }
        int tmp = nums[cur];
        nums[cur] = nums[end];
        nums[end] = tmp;
        return cur;
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        fastSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }


}
