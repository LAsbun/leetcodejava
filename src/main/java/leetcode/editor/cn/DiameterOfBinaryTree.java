/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * <p>
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * <p>
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * Related Topics 树 深度优先搜索 二叉树 👍 988 👎 0
 */

package leetcode.editor.cn;


import static leetcode.editor.cn.BalancedBinaryTree.buildTreeNodeFromArgs;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {

        Solution solution = new DiameterOfBinaryTree().new Solution();
        System.out.println(solution.diameterOfBinaryTree(buildTreeNodeFromArgs(new Integer[]{1, 2, 3, 4, 5})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        int maxLen;

        public int diameterOfBinaryTree(TreeNode root) {
            if (null == root) return 0;
            maxLen = 0;
            // 最大的长度就是左子树最长+右子树最长.
            doMax(root);

            return maxLen;

        }

        private int doMax(TreeNode root) {
            if (root == null) return 0;

            int left = doMax(root.left);
            int right = doMax(root.right);

            maxLen = Math.max(maxLen, left + right);

            return Math.max(left, right) + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}