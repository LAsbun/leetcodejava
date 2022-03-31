package leetcode.editor.cn;


import java.util.Arrays;

public class AllSortTest {

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};

        //mergeSort(array, 0, array.length - 1);
        heapSort(array);
        //FastSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    private static void heapSort(int[] nums) {


        // 构建堆
        for (int i = 0; i < nums.length; i++) {
            shiftUp(nums, i);
        }

        // 将最大元素与低元素互换.
        for (int i = 1; i < nums.length; i++) {
            swapArrayNum(nums, 0, nums.length - i);
            shiftDown(nums, nums.length - i, 0);
        }


    }

    private static void shiftDown(int[] allNums, int size, int i) {
        while (true) {
            // 找到 root root.left root.right 三者最大的那个
            int maxPos = i;

            if (i * 2 + 1 < size && allNums[maxPos] < allNums[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 < size && allNums[maxPos] < allNums[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) break;

            swapArrayNum(allNums, maxPos, i);
            i = maxPos;
        }

    }

    /**
     * 自下向上
     *
     * @param allNums
     * @param i
     */
    private static void shiftUp(int[] allNums, int i) {

        while (i > 0 && allNums[i] > allNums[(i - 1) / 2]) {
            swapArrayNum(allNums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }

    }

    private static void swapArrayNum(int[] allNums, int i, int j) {
        int tmp = allNums[i];
        allNums[i] = allNums[j];
        allNums[j] = tmp;
    }


    private static void mergeSort(int[] nums, int start, int end) {

        if (start >= end) return;

        int mid = (start + end) / 2;

        mergeSort(nums, mid + 1, end);
        mergeSort(nums, start, mid);

        mergeArray(nums, mid, start, end);


    }

    /**
     * 合并mid左右两边数据
     *
     * @param nums
     * @param mid
     */
    private static void mergeArray(int[] nums, int mid, int start, int end) {

        int i = start;
        int j = mid + 1;

        int[] tmp = new int[end - start + 1];
        int index = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
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


    private static void FastSort(int[] nums, int start, int end) {

        if (start >= end) return;

        int mid = doPartition(nums, start, end);

        FastSort(nums, mid + 1, end);
        FastSort(nums, start, mid - 1);

    }

    /**
     * 以end 为尾结点
     *
     * @param nums  待排序数组
     * @param start 起止
     * @param end   结束
     * @return
     */
    private static int doPartition(int[] nums, int start, int end) {

        int mm = nums[end];

        int cur = start;

        for (int i = start; i < end; i++) {
            if (nums[i] > mm) {
                int tmp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = tmp;
                ++cur;
            }

        }

        int tmp = nums[cur];
        nums[cur] = nums[end];
        nums[end] = tmp;

        return cur;
    }

}