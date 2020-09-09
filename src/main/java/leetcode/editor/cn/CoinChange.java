//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 803 👎 0


package leetcode.editor.cn;


public class CoinChange {
    public static void main(String[] args) {

        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
//            return findMinCoinNum(coins, amount);
            return dynamicFind(coins, amount);
        }

        private int dynamicFind(int[] coins, int amout) {
            // dp[n] = min(dp[n-coins[0]],dp[n-coins[1]]..)+1
            int[] dp = new int[amout + 1];
            dp[0] = 0;
            for (int i = 1; i <= amout; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++) {
                    int reduce = i - coins[j];
                    if (reduce < 0) continue;
                    if (dp[reduce] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[reduce] + 1, dp[i]);

                }
            }
            return dp[amout] == Integer.MAX_VALUE ? -1 : dp[amout];
        }

        // 暴力枚举
        private int findMinCoinNum(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int minCoinNum = findMinCoinNum(coins, amount - coins[i]);
                if (minCoinNum == -1) continue;
                res = Math.min(minCoinNum + 1, res);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}