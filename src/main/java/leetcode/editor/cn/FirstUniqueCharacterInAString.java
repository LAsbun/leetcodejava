//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 256 👎 0


package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {

        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i);
                Integer integer = map.computeIfAbsent(key, k -> 0);
                map.put(key, integer + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i);
                Integer integer = map.computeIfAbsent(key, k -> 0);
                if (integer == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}