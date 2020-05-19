//Given a binary tree, return the preorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics 栈 树


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {

        List<Integer> integers = new BinaryTreePreorderTraversal().new Solution().preorderTraversal(buildNode());
        integers.forEach(System.out::println);
    }


    public static TreeNode buildNode() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(8);

        return treeNode;
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
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> results = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();
            if (root != null)
                stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop != null) {
                    if (pop.right != null) {
                        stack.push(pop.right);
                    }
                    if (pop.left != null) {
                        stack.push(pop.left);
                    }
                    stack.push(pop);
                    stack.push(null);
                } else {
                    TreeNode cur = stack.pop();
                    results.add(cur.val);
                }
            }

            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}