//Given an integer n, generate all structurally unique BST's (binary search tree
//s) that store values 1 ... n. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//Explanation:
//The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics 树 动态规划


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = new UniqueBinarySearchTreesIi().new Solution().generateTrees(3);


        for (TreeNode treeNode : treeNodes) {
            preB(treeNode);
        }


    }

    // 前序遍历
    public static void preB(TreeNode root) {

        List<Integer> results = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode pop = stack.pop();
            if (null != pop) {
                if (null != pop.right)
                    stack.push(pop.right);

                if (null != pop.left)
                    stack.push(pop.left);

                stack.push(pop);
                stack.push(null);


            } else {
                pop = stack.pop();
                results.add(pop.val);
            }
        }


        System.out.println(Arrays.toString(results.toArray()));


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
        public List<TreeNode> generateTrees(int n) {

            if (0 == n) {
                return new ArrayList<>();
            }

            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            /**
             * 思路： 递归构建，
             * ① 对于每个递归，其实就是需要考虑子树的根节点，以及子树的左右树。
             * ② 但是左子树跟右子树的的根节点不同，则其构建的树也是不一样的，所以需要把所有子树的结果都保存起来
             *  就是用列表把所有的状态都保存起来
             * ③ 根据循环进行左子树右子树的构建
             *
             * 递归结束：
             *  就是到了叶子节点的下一个空节点(因为叶子节点也是有两种选择的)
             */

            List<TreeNode> all = new ArrayList<>();

            // 因为左子树有可能是为Null
            if (start > end) {
                // 返回一个空的
                all.add(null);
                return all;
            }


            // 选中根节点
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = generateTrees(start, i - 1);
                List<TreeNode> right = generateTrees(i + 1, end);

                // 当前根节点

                for (TreeNode leftNode : left) {
                    for (TreeNode rightNode : right) {
                        TreeNode cur = new TreeNode(i);

                        cur.left = leftNode;
                        cur.right = rightNode;
                        all.add(cur);
                    }

                }


            }

            return all;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}