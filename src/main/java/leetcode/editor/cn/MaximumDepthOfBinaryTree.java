//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 647 👎 0


package leetcode.editor.cn;


import javafx.util.Pair;

import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        System.out.println(solution.maxDepth(BinaryTreeInorderTraversal.buildNode()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 深度遍历下，即可
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {

            if (null == root) {
                return 0;
            }

            return dfs(root, 0);
//            return iterateDfs(root);
        }

        private int iterateDfs(TreeNode root) {
            Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

            int maxDepth = 0;

            stack.push(new Pair<>(root, 1));
            while (!stack.empty()) {
                Pair<TreeNode, Integer> pop = stack.pop();
                if (null != pop) {

                    if (null != pop.getKey().right) {
                        stack.push(new Pair<>(pop.getKey().right, pop.getValue() + 1));
                    }
                    if (null != pop.getKey().left) {
                        stack.push(new Pair<>(pop.getKey().left, pop.getValue() + 1));
                    }
                    stack.push(pop);
                    stack.push(null);

                } else {
                    pop = stack.pop();
                    maxDepth = Math.max(pop.getValue(), maxDepth);
                }
            }

            return maxDepth;
        }

        private int dfs(TreeNode treeNode, int depth) {
            if (null == treeNode) {
                return depth;
            }


            int left = dfs(treeNode.left, depth + 1);
            int right = dfs(treeNode.right, depth + 1);

            return Math.max(left, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}