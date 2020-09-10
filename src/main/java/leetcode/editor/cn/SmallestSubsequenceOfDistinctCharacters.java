//返回字符串 text 中按字典序排列最小的子序列，
// 该子序列包含 text 中所有不同字符一次。
//
// 
//
// 示例 1： 
//
// 输入："cdadabcc"
//输出："adbc"
// 
//
// 示例 2： 
//
// 输入："abcd"
//输出："abcd"
// 
//
// 示例 3： 
//
// 输入："ecbacba"
//输出："eacb"
// 
//
// 示例 4： 
//
// 输入："leetcode"
//输出："letcod"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由小写英文字母组成 
// 
//
// 
//
// 注意：本题目与 316 https://leetcode-cn.com/problems/remove-duplicate-letters/ 相同 
// Related Topics 字符串 
// 👍 46 👎 0


package leetcode.editor.cn;


import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {

        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
// 单调栈。遇到次数少的，就直接拒绝掉

            int[] cout = new int[26];

            for (int i = 0; i < s.length(); i++) {
                cout[s.charAt(i) - 'a']++;
            }

            boolean[] incl = new boolean[26];


            // 这里存储的一定是不重复的，且字典续是最小的
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);
                int num = c - 'a';
                if (incl[num]) {
                    cout[num]--;
                    continue;
                }
                ;
                while (!stack.isEmpty() && stack.peek() > c) {
                    Character peek = stack.peek();
                    int peeknum = peek - 'a';
                    // 如果没有重复的，就到此为止
                    if (cout[peeknum] <= 1) break;
                    cout[peeknum]--;
                    stack.pop();
                    incl[peeknum] = false;
                }

                stack.push(c);
                incl[num] = true;


            }

            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < stack.size(); i++) {
                buffer.append(stack.get(i));
            }

            return buffer.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}