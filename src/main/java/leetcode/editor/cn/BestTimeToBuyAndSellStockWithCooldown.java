/**
 * 给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * <p>
 * Related Topics 数组 动态规划 👍 1171 👎 0
 */

package leetcode.editor.cn;


public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {

        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];

            // bad case. dp[0][0] = 0 dp[0][1] = -p[0];

            //
            int frezz = 2;

            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {


                if (i - frezz >= 0) {
                    // 冷冻
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                    // 买的时候限制下
                    dp[i][1] = Math.max(dp[i - frezz][0] - prices[i], dp[i - 1][1]);
                } else {
                    // bad case
                    // 冷冻
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                    //
                    dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[0][1]);
                }
            }


            return dp[prices.length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}