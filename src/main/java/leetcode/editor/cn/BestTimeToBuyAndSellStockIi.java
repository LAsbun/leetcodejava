/**
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * <p>
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: prices = [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: prices = [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= prices.length <= 3 * 10⁴
 * 0 <= prices[i] <= 10⁴
 * <p>
 * Related Topics 贪心 数组 动态规划 👍 1656 👎 0
 */

package leetcode.editor.cn;


public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {

        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            /**
             * 动态规划, 因为同时只能持有一份股票，所以对于股票就有持有或者不持有
             * 定义 dp(m,0) 为在m天交易完后未持有 dp(m,1)为在m天交易完后持有
             * 则 dp(m,0) = max(dp(m-1,0), dp(m-1)[1]+prince[i])
             * 如果交易完后持有，如果前面未交
             * dp(m,1) = max(dp(m-1, 0)-p[m]), dp[i−1][1]))
             */

            //int[][] dp = new int[prices.length][2];

            // bad case. dp[0][0] = 0 dp[0][1] = -p[0];

            //dp[0][1] = -prices[0];

            int max0 = 0, max1 = -prices[0];
            int tmp0, tmp1;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    max0 += prices[i] - prices[i-1];
                }
            }


            return max0;


        }

        public int maxProfit2(int[] prices) {
            /**
             * 动态规划, 因为同时只能持有一份股票，所以对于股票就有持有或者不持有
             * 定义 dp(m,0) 为在m天交易完后未持有 dp(m,1)为在m天交易完后持有
             * 则 dp(m,0) = max(dp(m-1,0), dp(m-1)[1]+prince[i])
             * 如果交易完后持有，如果前面未交
             * dp(m,1) = max(dp(m-1, 0)-p[m]), dp[i−1][1]))
             */

            //int[][] dp = new int[prices.length][2];

            // bad case. dp[0][0] = 0 dp[0][1] = -p[0];

            //dp[0][1] = -prices[0];

            int max0 = 0, max1 = -prices[0];
            int tmp0, tmp1;
            for (int i = 1; i < prices.length; i++) {
                //dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                tmp0 = Math.max(max0, max1 + prices[i]);
                //dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
                tmp1 = Math.max(max0 - prices[i], max1);
                max0 = tmp0;
                max1 = tmp1;
            }


            return max0;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}