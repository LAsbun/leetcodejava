/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 100
 * <p>
 * <p>
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 265 👎 0
 */

package leetcode.editor.cn;


public class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {

        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        System.out.println(solution.numWays(3));
        System.out.println(solution.numWays(7));
        System.out.println(solution.numWays(100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {

            if (n < 2) return 1;

            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }

            return dp[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}