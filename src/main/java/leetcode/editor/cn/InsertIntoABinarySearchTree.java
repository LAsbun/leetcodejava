//给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。 
//
// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。 
//
// 例如, 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和 插入的值: 5
// 
//
// 你可以返回这个二叉搜索树: 
//
// 
//         4
//       /   \
//      2     7
//     / \   /
//    1   3 5
// 
//
// 或者这个树也是有效的: 
//
// 
//         5
//       /   \
//      2     7
//     / \   
//    1   3
//         \
//          4
// 
// Related Topics 树 
// 👍 72 👎 0


package leetcode.editor.cn;


import java.util.Arrays;
import java.util.List;

import static leetcode.editor.cn.BalancedBinaryTree.buildTreeNodeFromArgs;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {

        Solution solution = new InsertIntoABinarySearchTree().new Solution();
        TreeNode treeNode = solution.insertIntoBST(buildTreeNodeFromArgs(new Integer[]{4, 2, 7, 1, 3}), 5);
        List<Integer> integers = new BinaryTreePreorderTraversal().new Solution().preorderTraversal(treeNode);

        System.out.println(Arrays.toString(integers.toArray()));
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
        public TreeNode insertIntoBST(TreeNode root, int val) {

            if (null == root) {
                return new TreeNode(val);
            }

            // 二叉树插入  找到叶子节点，插入即可。
            TreeNode tmpNode = root;
            boolean flag = true;
            while (flag) {
                if (tmpNode.val > val) {
                    if (null == tmpNode.left) {
                        tmpNode.left = new TreeNode(val);
                        flag = false;
                        continue;
                    }
                    tmpNode = tmpNode.left;

                } else {
                    if (null == tmpNode.right) {
                        tmpNode.right = new TreeNode(val);
                        flag = false;
                        continue;
                    }
                    tmpNode = tmpNode.right;
                }


            }

            return root;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
