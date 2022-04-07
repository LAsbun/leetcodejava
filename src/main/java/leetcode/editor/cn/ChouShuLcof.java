//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 310 👎 0


package leetcode.editor.cn;


public class ChouShuLcof {
    public static void main(String[] args) {

        Solution solution = new ChouShuLcof().new Solution();
        System.out.println(solution.nthUglyNumber(10));
        System.out.println(solution.nthUglyNumber(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {

            /**
             * 动态规划
             * 状态转移方程 dp[i] = min(dp[p2]*2, dp[p3]*3, dp[p5]*5)
             *
             * dp[n]*2 > dp[n] > dp[n-1]*2
             * dp[n]*3 > dp[n] > dp[n-1]*3
             * dp[n]*5 > dp[n] > dp[n-1]*5
             *
             * 同时记录 当前2，3，5的次数相乘一下.
             */
            int[] dp = new int[n];

            dp[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0;

            for (int i = 1; i < n; i++) {
                dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
                if (dp[i] == dp[p2] * 2) p2++;
                if (dp[i] == dp[p3] * 3) p3++;
                if (dp[i] == dp[p5] * 5) p5++;
            }

            return dp[n-1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}