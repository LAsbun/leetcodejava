//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 557 👎 0


package leetcode.editor.cn;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static leetcode.editor.cn.BalancedBinaryTree.buildTreeNodeFromArgs;

public class InvertBinaryTree {
    public static void main(String[] args) {

        Solution solution = new InvertBinaryTree().new Solution();

//        TreeNode treeNode = buildTreeNodeFromArgs(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode treeNode = buildTreeNodeFromArgs(new Integer[]{});
        TreeNode treeNode1 = solution.invertTree(treeNode);
        BinaryTreePreorderTraversal.Solution solution1 = new BinaryTreePreorderTraversal().new Solution();
        List<Integer> list = solution1.preorderTraversal(treeNode1);
        System.out.println(Arrays.toString(list.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {

            if (null == root) {
                return root;
            }

            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (null != pop) {
                    TreeNode node = pop.left;
                    pop.left = pop.right;
                    pop.right = node;
                    stack.push(pop);
                    stack.push(null);
                    if (null != pop.left) {
                        stack.push(pop.left);
                    }
                    if (null != pop.right) {
                        stack.push(pop.right);
                    }
                } else {
                    stack.pop();
                }
            }

            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}