//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 272 👎 0


package leetcode.editor.cn;


import javafx.util.Pair;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {

        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        List<List<Integer>> lists = solution.levelOrderBottom(BalancedBinaryTree.buildTreeNodeFromArgs(new Integer[]{3, 9, 20, null, null, 15, 7}));
//        List<List<Integer>> lists = solution.levelOrderBottom(null);
        System.out.println("xxx");
        System.out.println("xxx");
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // 前序遍历，然后再保存枚举值即可

            if (null == root) {
                return new ArrayList<>();
            }

            Map<Integer, List<Integer>> resultMap = new HashMap<>();

            Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

            stack.push(new Pair<>(root, 1));

            while (!stack.isEmpty()) {
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
                    List<Integer> integers = resultMap.computeIfAbsent(pop.getValue(), k -> new ArrayList<>());
                    integers.add(pop.getKey().val);
                }
            }


            ArrayList<List<Integer>> list = new ArrayList<>(resultMap.values());
            Collections.reverse(list);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}