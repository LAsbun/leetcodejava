/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * <p>
 * Related Topics 数组 动态规划 👍 1232 👎 0
 */

package leetcode.editor.cn;


public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

        Solution solution = new PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            /**
             * 转化成0-1背包
             */

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (sum % 2 != 0) return false;
            sum /= 2;


            boolean[][] dp = new boolean[nums.length + 1][sum + 1];

            for (int i = 0; i < nums.length + 1; i++) {
                dp[i][0] = true;
            }

            for (int i = 1; i < nums.length+1; i++) {
                for (int j = 1; j < sum + 1; j++) {
                    if (j - nums[i - 1] >= 0) {
                        // 不装入||装入
                        dp[i][j] = dp[i - 1][j] || dp[i-1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[nums.length][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}