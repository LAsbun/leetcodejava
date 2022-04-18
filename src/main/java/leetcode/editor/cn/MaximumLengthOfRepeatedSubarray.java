/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 * <p>
 * Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 664 👎 0
 */

package leetcode.editor.cn;


public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {

        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
        System.out.println(solution.findLength(new int[]{3, 2, 1, 4, 5}, new int[]{2, 1, 3, 2, 1}));
        System.out.println(solution.findLength(new int[]{3, 2, 1, 4, 5}, new int[]{3, 2, 1, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            /**
             * 最长公共子串类似解法
             * 定义 dp(m,n) 为num1(0...m) num2(0...n)的最长公共子数组
             */
            int[][] dp = new int[nums1.length + 1][nums1.length + 1];


            int max = 0;

            for (int i = 1; i < nums1.length + 1; i++) {
                for (int j = 1; j < nums2.length + 1; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }


            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}