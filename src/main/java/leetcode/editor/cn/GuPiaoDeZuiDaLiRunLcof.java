//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
//stock/ 
// Related Topics 数组 动态规划 👍 228 👎 0


package leetcode.editor.cn;


public class GuPiaoDeZuiDaLiRunLcof {
    public static void main(String[] args) {

        Solution solution = new GuPiaoDeZuiDaLiRunLcof().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            // 思路: 对于N 只需要找0~N-1 最小的即可。
            // dp[n] 存储的是0~N-1中最小的数字。状态转移方程，dp[n] = dp[n-1]||a[n]

            if (prices.length < 2) return 0;

            int[] dp = new int[prices.length];
            dp[0] = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i - 1] < dp[i - 1]) {
                    dp[i] = prices[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                ans = Math.max(ans, prices[i] - dp[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}