package elementary_algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String input = "loveleetcode";
        System.out.println("{input = " + input + "}, {output = " + firstUniqChar(input) + "}");
    }

    public static int firstUniqChar(String s) {
        char[] array = s.toCharArray();
//        Arrays.sort(array);
//        for (int i = 0; i < array.length - 1; i += 2) {
//            if (array[i] != array[i+1]) {
//                return s.indexOf(array[i]);
//            }
//        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (char c: array) {
            int charValue = c - 'a';
            hashMap.put(charValue, hashMap.getOrDefault(charValue, 0) + 1);
        }
        for (int i = 0; i < array.length; i++) {
            int charValue = array[i] - 'a';
            if (hashMap.get(charValue) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqCharRef(String s) {
        int ans = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // 获取当前字符的索引位置
            int index = s.indexOf(ch);
            // 比较当前字符正向与反向的索引值是否相同
            if (index != -1 && index == s.lastIndexOf(ch)) {
                ans = (ans == -1 || ans > index) ? index: ans;
            }
        }
        return ans;
    }


}
