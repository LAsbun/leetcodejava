//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 二分查找 分治 矩阵 👍 608 👎 0


package leetcode.editor.cn;


public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {

        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();

        int[][] matrixs = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        //System.out.println(solution.findNumberIn2DArray(matrixs, 1));
        //System.out.println(solution.findNumberIn2DArray(matrixs, 18));
        //System.out.println(solution.findNumberIn2DArray(matrixs, 15));
        //System.out.println(solution.findNumberIn2DArray(matrixs, 30));
        //System.out.println(solution.findNumberIn2DArray(matrixs, 17));
        //System.out.println(solution.findNumberIn2DArray(matrixs, 100));
        //System.out.println(solution.findNumberIn2DArray(new int[][]{{}, {}}, 100));
        System.out.println(solution.findNumberIn2DArray(new int[][]{{1, 2, 3, 4, 5}}, 6));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            // 每个都是个矩阵，通过矩阵进行分治
            int lu = 0;
            int rl = 0;
            int lb = matrix.length;
            if (lb == 0) return false;
            int rr = matrix[0].length;
            if (rr == 0) return false;
            return bisearch(lu, lb - 1, rl, rr - 1, target, matrix);
        }

        private boolean bisearch(int lu, int lb, int target, int[][] matrix) {
            return false;
        }

        private boolean bisearch(int lu, int lb, int rl, int rr, int target, int[][] matrix) {
            if (lu > lb || rl > rr || lb >= matrix.length || rl >= matrix[0].length || lb < 0 || rl < 0) return false;

            int midl = (lu + lb + 1) / 2;
            int midr = (rl + rr + 1) / 2;
            if (matrix[midl][midr] == target) return true;
            else if (matrix[midl][midr] < target) {
                // 左下角矩阵
                return bisearch(midl + 1, lb, rl, midr, target, matrix)
                        // 右下角矩阵
                        || bisearch(midl, lb, midr + 1, rr, target, matrix)
                        // 右上角矩阵
                        || bisearch(lu, midr - 1, midr + 1, rr, target, matrix);
            } else {
                // 左上角矩阵
                return bisearch(lu, midl, rl, midr - 1, target, matrix)
                        // 左下角矩阵
                        || bisearch(midl + 1, lb, rl, midr - 1, target, matrix)
                        // 右上角矩阵
                        || bisearch(lu, midl - 1, midr, rr, target, matrix);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}