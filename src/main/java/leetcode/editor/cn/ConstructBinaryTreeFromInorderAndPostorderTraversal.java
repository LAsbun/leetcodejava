//Given inorder and postorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组


package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {

        TreeNode treeNode = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution().buildTree(
                new int[]{4, 3, 5, 2, 1, 6, 8, 7},
//                new int[]{9, 3, 15, 20, 7},
                new int[]{4, 5, 3, 2, 8, 7, 6, 1}
//                new int[]{9, 15, 7, 20, 3}
        );

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

        private HashMap<Integer, Integer> idMap;
        private Integer index;

        public TreeNode buildTree(int[] inorder, int[] postorder) {

            /**
             * 思路，
             * 中序遍历是 左 中 右
             * 后续遍历是 左 右 中
             * //inorder = [9,3,15,20,7]
             * //postorder = [9,15,7,20,3]
             * 所以后续遍历最后一个节点一定是该树的root [3]
             * 则在中序遍历中  [9] 一定是左子树  [15,20,7] 一定是右子树
             *
             * 就是从后往前遍历 后续遍历的结果，从中序遍历找到对应的子树，先构建右子树，再构建左子树
             */
            // 后续遍历的最后一个
            index = postorder.length - 1;

            idMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                idMap.put(inorder[i], i);
            }

            return dfsBuildTreeFromInorderAndPostOrder(postorder, 0, inorder.length);

        }

        private TreeNode dfsBuildTreeFromInorderAndPostOrder(int[] postorder, int start, int end) {

            if (start == end) {
                return null;
            }

            int curValue = postorder[index];

            TreeNode root = new TreeNode(curValue);

            Integer mid = idMap.get(curValue);

            index--;

            root.right = dfsBuildTreeFromInorderAndPostOrder(postorder, mid + 1, end);
            root.left = dfsBuildTreeFromInorderAndPostOrder(postorder, start, mid);

            return root;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}