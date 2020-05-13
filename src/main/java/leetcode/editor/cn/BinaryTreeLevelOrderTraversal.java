//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package leetcode.editor.cn;


import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        List<List<Integer>> listList = new BinaryTreeLevelOrderTraversal().new Solution().levelOrder(BinaryTreeInorderTraversal.buildNode());

        listList.forEach(c -> System.out.println(Arrays.toString(c.toArray())));
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
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> listList = new ArrayList<>();

            // 广搜 + 中序遍历
            // null 作为分层符

            LinkedList<TreeNode> queue = new LinkedList<>();

            // 下一次层次的
            LinkedList<TreeNode> nextQueue = new LinkedList<>();


            if (root != null) {
                queue.add(root);
            }

            List<Integer> list = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode pop = queue.pop();
                if (pop != null) {
                    list.add(pop.val);
                    if (null != pop.left) {
                        nextQueue.add(pop.left);
                    }
                    if (null != pop.right) {
                        nextQueue.add(pop.right);
                    }
                }

                // 判断上一层次是否遍历完
                if (queue.isEmpty()) {
                    listList.add(list);
                    list = new ArrayList<>();
                    // 判断下一层次是否有节点
                    if (!nextQueue.isEmpty()) {
                        queue = nextQueue;
                        nextQueue = new LinkedList<>();
                    }
                }
            }

            return listList;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}