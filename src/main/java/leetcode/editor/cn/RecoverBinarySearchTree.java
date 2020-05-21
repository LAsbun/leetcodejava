//Two elements of a binary search tree (BST) are swapped by mistake. 
//
// Recover the tree without changing its structure. 
//
// Example 1: 
//
// 
//Input: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//Output: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// Example 2: 
//
// 
//Input: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//Output: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
// 
//
// Follow up: 
//
// 
// A solution using O(n) space is pretty straight forward. 
// Could you devise a constant space solution? 
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;


import java.util.*;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {

        TreeNode treeNode = buildTreeNode();

        List<Integer> list1 = new BinaryTreePreorderTraversal().new Solution().preorderTraversal(treeNode);
        System.out.println(Arrays.toString(list1.toArray()));


        new RecoverBinarySearchTree().new Solution().recoverTree(treeNode);

        List<Integer> list = new BinaryTreeInorderTraversal().new Solution().inorderTraversal(treeNode);
        System.out.println(Arrays.toString(list.toArray()));

        List<Integer> list2 = new BinaryTreePreorderTraversal().new Solution().preorderTraversal(treeNode);
        System.out.println(Arrays.toString(list2.toArray()));


    }

    private static TreeNode buildTreeNode() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(2);

//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(2);

//        TreeNode treeNode = new TreeNode(5);
//        treeNode.left = new TreeNode(3);
//        treeNode.right = new TreeNode(9);
//
//        treeNode.left.left = new TreeNode(-2147483648);
//        treeNode.left.right = new TreeNode(2);

        return treeNode;

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
        public void recoverTree(TreeNode root) {

            /**
             * 思路：
             * 因为BTS 中序遍历一定是一个递增的数组，
             * 所以先遍历所有的节点，保存所有的值
             *
             * 如果存在改动的节点，一定会出现不是一个递增的数组。
             * 因为有两个节点改动，
             * 所以最少会出现一次非递增[1,3,2,4,5]->[1,2,3,4,5]， 其中[3,2]算一次非递增 需要交换的就是3,2
             * 最多出现2次递增[1,4,3,2,5] -> [4，3]算一次非递增，[3,2]算一次非递增。需要交换的就是4，2
             *  所以根据出现的次数，进行不同的取值
             *
             *
             * 实际复杂度O(n^2)  空间复杂度 O(n)
             */


            Stack<TreeNode> nodeStack = new Stack<>();

            nodeStack.push(root);

            ArrayList<Integer> list = new ArrayList<>();

            while (!nodeStack.isEmpty()) {

                TreeNode pop = nodeStack.pop();

                if (pop != null) {
                    if (null != pop.right) {
                        nodeStack.push(pop.right);
                    }
                    nodeStack.push(pop);
                    nodeStack.push(null);
                    if (null != pop.left) {
                        nodeStack.push(pop.left);
                    }
                } else {
                    pop = nodeStack.pop();
                    list.add(pop.val);
                }

            }

            int first = -1;
            int end = -1;

            for (int i = 0; i < list.size() - 1; i++) {

                if (list.get(i) > list.get(i + 1)) {

                    if (first == -1) {
                        first = list.get(i);
                    }
                    end = list.get(i + 1);

                }

            }

            int index = 2;

            nodeStack.push(root);

            while (!nodeStack.isEmpty()) {

                TreeNode pop = nodeStack.pop();

                if (pop != null) {
                    if (null != pop.right) {
                        nodeStack.push(pop.right);
                    }
                    nodeStack.push(pop);
                    nodeStack.push(null);
                    if (null != pop.left) {
                        nodeStack.push(pop.left);
                    }
                } else {
                    pop = nodeStack.pop();
                    if (pop.val == first) {
                        pop.val = end;
                        index--;
                    } else if (pop.val == end) {
                        pop.val = first;
                        index--;

                    }

                    if (index == 0) {
                        return;
                    }
                }

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}