//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {

        TreeNode treeNode = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution().buildTree(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                new int[]{4, 3, 5, 2, 1, 6, 8, 7});

        List<Integer> list = new BinaryTreePreorderTraversal().new Solution().preorderTraversal(treeNode);
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

        HashMap<Integer, Integer> inorderMapIndex;

        int index = 0;

        /**
         * 思路: 由前序+中序构建一个树
         * <p>
         * 根节点在前序一定是第一个节点。题目里面是[3]
         * <p>
         * 注意：左右子树都是相较于前序遍历的。
         * <p>
         * 中序遍历在根节点之前的节点，一定是属于前序遍历的左子树[9]。 在根节点之后的一定是右子树[15,20,7]。
         * <p>
         * 接下来就是找左子树的根，与右子树的根。
         * <p>
         * 在前序遍历中先遍历到的一定是子树的根节点。
         * 例如中序遍历右子树为[15,20,7] 在前序遍历中20先出现，那么20就是右子树的根.
         * 右子树的左子树为[15] 右子树为[7]
         * <p>
         * 右子树的左子树为[15](如果只有一个值，那么就是其子树的根节点)
         * <p>
         * 所以先根据前序遍历，找到每个节点的左右节点的数据，
         * 然后再拆分左右子树的根节点一起左右子树根节点的左右子树，
         * 依次递归，直到找到某一棵树的叶子节点，然后就把子树构建完成，向上递归即可构建一颗树。
         *
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderMapIndex = new HashMap<>();
            index = 0;


            for (int i = 0; i < inorder.length; i++) {
                inorderMapIndex.put(inorder[i], i);
            }

            TreeNode treeNode = dfsBuildTree(preorder, 0, preorder.length);
            return treeNode;

        }


        /**
         * @param preorder
         * @param start    当前树对应的inorder 区间起始位
         * @param end      当前树对应的inorder 区间终止位
         * @return
         */
        private TreeNode dfsBuildTree(int[] preorder, int start, int end) {

            if (start == end) {
                return null;
            }


            int x = preorder[index];

            TreeNode root = new TreeNode(x);


            Integer mid = inorderMapIndex.get(x);

            ++index;


            root.left = dfsBuildTree(preorder, start, mid);
            root.right = dfsBuildTree(preorder, mid + 1, end);

            return root;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}