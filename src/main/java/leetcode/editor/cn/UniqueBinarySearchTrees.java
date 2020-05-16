//Given n, how many structurally unique BST's (binary search trees) that store v
//alues 1 ... n? 
//
// Example: 
//
// 
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics 树 动态规划


package leetcode.editor.cn;


public class UniqueBinarySearchTrees {
    public static void main(String[] args) {

        System.out.println(new UniqueBinarySearchTrees().new Solution().numTrees(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int numTrees(int n) {
            /**
             * 思路： 二叉搜索树 左节点一定是小于/父节点， 右节点一定是大与等于父节点。
             *  如果我们知道一个根节点，就能够判断出其子节点的区间范围.
             *  每个左右节点也可以做为一个子区间，左右子区间的乘积就是该根节点的结果。
             *  即 F(i,n) = F(0,i-1) * F(i+1, n)。
             *
             *  接下来就是如果选取根节点。n 就有 n 种根节点选择
             *
             *  所以就是G(n) = G(0)G(n-1)[以第一个节点为根节点，那么左边就是0个比1小的。右边就是n-1个比1大的]
             *          + G(1)G(n-2)....G(n-1)G(0)
             */
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {

                    dp[i] += dp[j - 1] * dp[i - j];
                }

            }

            return dp[n];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}