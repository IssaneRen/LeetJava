package elementary_algorithm.string;

/**
 * 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class StrStr {
    public static void main(String[] args) {
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "hello", needle = "ll";
        String haystack = "a", needle = "a";
        System.out.println("{haystack = " + haystack+ "}, {needle = " + needle + "}, {output(isPalindrome) = " + strStr2(haystack, needle) + "}");
    }

    /**
     * 直接使用底层方法，简单粗暴
     */
    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        char[] charArr = haystack.toCharArray(), compArr = needle.toCharArray();
        for (int i = 0; i <= charArr.length - compArr.length; i++) {
            if (charArr[i] == compArr[0]) {
                boolean same = true;
                for (int j = 0; j < compArr.length; j++) {
                    if (charArr[i + j] != compArr[j]) {
                        same = false;
                        break;
                    }
                }
                if (same)
                    return i;
            }
        }
        return -1;
    }
}
