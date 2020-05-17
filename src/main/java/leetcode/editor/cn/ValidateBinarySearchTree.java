//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;


import java.util.*;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

        TreeNode treeNode = buildBTS();

        boolean validBST = new ValidateBinarySearchTree().new Solution().isValidBST(treeNode);
        System.out.println(validBST);
    }

    private static TreeNode buildBTS() {

        // 标准

        TreeNode root = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left = new TreeNode(1);

        return null;

    }

    private static TreeNode buildNoBTS() {

        // 标准

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        return root;

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
        public boolean isValidBST(TreeNode root) {

            if (root == null) {
                return true;
            }

            return no3Solution(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }


        // 这个最快  空间复杂度与solution2 一样
        private Boolean no3Solution(TreeNode root, Long min, Long max) {
            /**
             * 对于左节点的值，一定是大于最小值，小于父节点的值
             * 对于有节点的值，一定是大于父节点的值，小于最大值。
             *
             * 所以我们可以深度遍历所有节点。判断子节点的区间范围是否合理即可
             *
             *
             * 初始的是Integer.Min Integer.Max
             */


            if (root.val <= min || root.val >= max) {
                return false;
            }

            Boolean result = true;

            if (null != root.left) {
                result = no3Solution(root.left, min, (long) root.val);
            }

            if (result && null != root.right) {
                result = no3Solution(root.right, (long) root.val, max);
            }
            return result;


        }


        // 这个跟solution3比运行时间一样，但是空间复杂度较小
        private Boolean no2Solution(TreeNode root) {


            /**
             * BTS 的中序遍历 是升序的。中序遍历检查前面的节点与当前节点
             */

            LinkedList<Integer> list = new LinkedList<>();

            Stack<TreeNode> stack = new Stack<>();
            if (null != root) {
                stack.push(root);
            }

            while (!stack.isEmpty()) {

                TreeNode pop = stack.pop();
                if (null != pop) {
                    if (null != pop.right) {
                        stack.push(pop.right);
                    }
                    stack.push(pop);
                    stack.push(null);
                    if (null != pop.left) {
                        stack.push(pop.left);
                    }
                } else {

                    pop = stack.pop();

                    if (list.size() != 0) {
                        Integer last = list.getLast();
                        if (pop.val <= last) {
                            return false;
                        }

                    }
                    list.addLast(pop.val);
                }

            }

            return true;
        }


        private Boolean no1Solution(TreeNode root) {

            /**
             * 思路： 每一个节点都要大于左子树的所有节点，都要小于右子树的所有节点。
             *
             * 保存所有左右子树的节点，然后比较
             */

            if (null == root) {
                return true;
            }

            List<TreeNode> validBSTReal = isValidBSTReal(root);
            if (null == validBSTReal) {
                return false;
            } else {
                return true;
            }
        }


        private List<TreeNode> isValidBSTReal(TreeNode treeNode) {

            // 先检查当前节点是否与前面的父节点都一样


            List<TreeNode> all = new ArrayList<>();
            List<TreeNode> right = new ArrayList<>();
            List<TreeNode> left = new ArrayList<>();

            // 右子树

            if (null != treeNode.right) {
                right = isValidBSTReal(treeNode.right);
            }

            // 返回null 就表示子树不满足BTS

            if (null == right) {
                return null;
            }


            for (TreeNode node : right) {
                if (treeNode.val >= node.val) {
                    return null;
                }
            }


            // 左子树

            if (null != treeNode.left) {
                left = isValidBSTReal(treeNode.left);
            }

            if (null == left) {
                return null;
            }

            for (TreeNode node : left) {
                if (treeNode.val <= node.val) {
                    return null;
                }
            }

            // 到这里一定是当前节点满足大于左子树，小于右子树

            all.addAll(left);
            all.add(treeNode);
            all.addAll(right);

            return all;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}