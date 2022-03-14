//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 541 👎 0


package leetcode.editor.cn;


public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {

        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        //System.out.println(solution.exist(new char[][]{{'a','b'},{'c','d'}}, "cdba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] bool;
        int wordIndex = 0;

        public boolean exist(char[][] board, String word) {
            // 思路：枚举递归。

            bool = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        bool[i][j] = true;
                        wordIndex = 1;
                        boolean b = doFind(i, j, word, board);
                        if (b) return b;
                        bool[i][j] = false;

                    }
                }
            }

            return false;

        }

        private boolean doFind(int curub, int curl, String word, char[][] board) {

            if(wordIndex >= word.length()) return true;

            // 上
            if (curub - 1 >= 0 && !bool[curub - 1][curl] && word.charAt(wordIndex) == board[curub - 1][curl]) {
                bool[curub - 1][curl] = true;
                ++wordIndex;
                boolean b = doFind(curub - 1, curl, word, board);
                if (b) return b;
                else {
                    // 如果没有找到解，则恢复之前的场景
                    --wordIndex;
                    bool[curub - 1][curl] = false;
                }
            }

            // 下
            if (curub + 1 < board.length && !bool[curub + 1][curl] && word.charAt(wordIndex) == board[curub + 1][curl]) {
                bool[curub + 1][curl] = true;
                ++wordIndex;
                boolean b = doFind(curub + 1, curl, word, board);
                if (b) return b;
                else {
                    // 如果没有找到解，则恢复之前的场景
                    --wordIndex;
                    bool[curub + 1][curl] = false;
                }
            }

            // 右
            if (curl + 1 < board[0].length && !bool[curub][curl + 1] && word.charAt(wordIndex) == board[curub][curl + 1]) {
                bool[curub][curl + 1] = true;
                ++wordIndex;
                boolean b = doFind(curub, curl + 1, word, board);
                if (b) return b;
                else {
                    // 如果没有找到解，则恢复之前的场景
                    --wordIndex;
                    bool[curub][curl + 1] = false;
                }
            }

            // 右
            if (curl - 1 >= 0 && !bool[curub][curl - 1] && word.charAt(wordIndex) == board[curub][curl - 1]) {
                bool[curub][curl - 1] = true;
                ++wordIndex;
                boolean b = doFind(curub, curl - 1, word, board);
                if (b) return b;
                else {
                    // 如果没有找到解，则恢复之前的场景
                    --wordIndex;
                    bool[curub][curl - 1] = false;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}