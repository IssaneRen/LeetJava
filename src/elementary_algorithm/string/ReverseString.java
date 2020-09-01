package elementary_algorithm.string;

import util.CommonUtils;

/**
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'H', 'e', 'l', 'l', 'o', '!'};
        reverseString(s);
        System.out.println(" {result: " + CommonUtils.array2String(s) + "}");
    }

    public static void reverseString(char[] s) {
//        if (s == null || s.length <= 1)
//            return;
        int startCursor = 0, endCursor = s.length -1;
        char tmp;
        while (startCursor < endCursor) {
            tmp = s[startCursor];
            s[startCursor++] = s[endCursor];
            s[endCursor--] = tmp;
        }
    }
}
