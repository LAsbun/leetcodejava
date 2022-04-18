/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子
 * 序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * Related Topics 数组 👍 264 👎 0
 */

package leetcode.editor.cn;


public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {

        Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
        System.out.println(solution.findLengthOfLCIS(new int[]{3,1,2}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5}));
        System.out.println(solution.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 2, 3}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 2, 3, 1, 2}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            /**
             * 双指针//动态规划
             */
            if (nums.length <= 1) return nums.length;

            int left = 0, right = 1, max = 0;

            while (right < nums.length) {

                if (nums[right] <= nums[right - 1]) {
                    max = Math.max(right - left, max);
                    left = right;
                }
                ++right;

            }

            // badcase 以防到末尾最长，所以需要判断下left与结尾的举例
            max = Math.max(nums.length - left, max);


            return max;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}