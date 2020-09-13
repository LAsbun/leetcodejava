//给定一个按照升序排列的整数数组 nums，
// 和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 586 👎 0


package leetcode.editor.cn;


import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {

        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        System.out.println(Arrays.toString(solution.searchRange(new int[]{6}, 6)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int leftIndex = findLeftIndex(nums, target);
            int rightIndex = findRightIndex(nums, target);
            return new int[]{leftIndex, rightIndex};


        }

        private int findLeftIndex(int[] nums, int target) {
            int length = nums.length;
            int left = 0;
            int right = length - 1;

            int index = Integer.MAX_VALUE;

            while (left <= right) {

                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    index = Math.min(index, mid);
                }

                // 这里是需要判断下如果只有1个元素，比较下
                if (left == right) {
                    break;
                }

                if (nums[mid] >= target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }

            return index == Integer.MAX_VALUE ? -1 : index;
        }

        private int findRightIndex(int[] nums, int target) {
            int length = nums.length;
            int left = 0;
            int right = length - 1;

            int index = Integer.MIN_VALUE;

            while (left <= right) {

                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    index = Math.max(index, mid);
                }

                // 这里是需要判断下如果只有1个元素，比较下
                if (left == right) {
                    break;
                }

                if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] <= target) {
                    left = mid + 1;
                }
            }

            return index == Integer.MIN_VALUE ? -1 : index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}