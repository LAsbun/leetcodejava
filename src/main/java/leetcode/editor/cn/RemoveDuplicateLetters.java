//给你一个仅包含小写字母的字符串，
// 请你去除字符串中重复的字母，使得每个字母只出现一次。
// 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1: 
//
// 输入: "bcabc"
//输出: "abc"
// 
//
// 示例 2: 
//
// 输入: "cbacdcbc"
//输出: "acdb" 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
// Related Topics 栈 贪心算法 
// 👍 212 👎 0


package leetcode.editor.cn;


import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {

        Solution solution = new RemoveDuplicateLetters().new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solution.removeDuplicateLetters("ecbacba"));
        System.out.println(solution.removeDuplicateLetters("bbcaac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
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