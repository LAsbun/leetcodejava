/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：amount = 10, coins = [10]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 * <p>
 * Related Topics 数组 动态规划 👍 767 👎 0
 */

package leetcode.editor.cn;


import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {

        Solution solution = new CoinChange2().new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change(4, new int[]{1, 2, 5}));
        System.out.println(solution.change(5, new int[]{5}));
        //System.out.println(solution.change(5, new int[]{6}));
        //System.out.println(solution.change(0, new int[]{6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int change(int amount, int[] coins) {
            /**
             * 完全背包. 无限次使用
             */

            int[] dp = new int[amount + 1];

            // bad case
            dp[0] = 1;
            /**
             * 状态2个  dp[i][j] 使用前i个组成j金额
             */

            for (int i = 1; i <= coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i - 1] >= 0) {
                        dp[j] = dp[j] + dp[j - coins[i - 1]];
                    }
                }
            }

            return dp[amount];
        }

        public int change2(int amount, int[] coins) {
            /**
             * 完全背包. 无限次使用
             */

            int[][] dp = new int[coins.length + 1][amount + 1];

            // bad case
            for (int i = 0; i < coins.length + 1; i++) {
                dp[i][0] = 1;
            }

            /**
             * 状态2个  dp[i][j] 使用前i个组成j金额
             */

            for (int i = 1; i <= coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[coins.length][amount];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}