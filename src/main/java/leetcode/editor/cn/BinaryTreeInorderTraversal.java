//Given a binary tree, return the inorder traversal of its nodes' values.
//
// Example:
//
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2]
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
// Related Topics 栈 树 哈希表


package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 中序遍历: 先遍历左节点，然后再主节点，然后再访问右节点。
 * 前序遍历：先主节点，再左节点，再右节点
 * 后续遍历：先左节点，再右节点，再主节点
 */

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
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
                stack.push(pop);
                stack.push(null);
                if (pop.left != null) {
                    stack.push(pop.left);
                }

            } else {
                TreeNode cur = stack.pop();
                results.add(cur.val);
            }
        }

        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

        List<Integer> integers = new Solution().inorderTraversal(buildNode());
        integers.forEach(System.out::println);
    }


    public static TreeNode buildNode() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.left.right = new TreeNode(7);
        treeNode.left.right.left = new TreeNode(9);

        return treeNode;
    }
}