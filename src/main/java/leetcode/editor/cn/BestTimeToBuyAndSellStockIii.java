/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：prices = [7,6,4,3,1] StringBuffer
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：prices = [1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁵
 * <p>
 * Related Topics 数组 动态规划 👍 1082 👎 0
 */

package leetcode.editor.cn;


public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {

        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        System.out.println(solution.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solution.maxProfit(new int[]{7,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            /**
             * 定义状态 dp(m,k,0) 标识在第i天交易完成之后,已经交易了k次，手里面没有股票 的收益
             * 注意只有买的时候才视为交易了
             * dp(m,k,0) = max(dp(m-1,k,1)+p[i]{表示前一天持有，今天卖掉了},  dp(m-1,k,0){表示前一天未持有，今天也没有操作})
             * dp(m,k,1) = max(dp(m-1,k,1){表示前一天持有，未操作},  dp(m-1,k-1,0)-p[i]{表示前一天持有，今天有操作})
             * bad case dp[0][0][1] = -INF 没有操作就持有，就是正无穷 dp[0][0][0] = 0
             */

            int k = 2;

            int[][][] dp = new int[prices.length][k + 1][2];

            dp[0][0][1] = Integer.MIN_VALUE;

            for (int i = 0; i < prices.length; i++) {
                for (int j = 1; j <= k; j++) {
                    // bad case
                    if (i == 0) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
                }
            }

            return dp[prices.length - 1][2][0];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}