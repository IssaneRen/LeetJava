package elementary_algorithm.string;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsPalindrome {
    public static void main(String[] args) {
//        String input = "A man, a plan, a canal: Panama";
//        String input = "race a car";
        String input = "0P";
        System.out.println("{input = " + input + "}, {output(isPalindrome) = " + isPalindrome(input) + "}");
//        System.out.println("char a: " + (int) 'a' + "; char A:" + (int)'A' + "; char 0" + (int)'0');
//        for (int i = 0; i < 128; i++) {
//            System.out.println("char of int: " + i + "----------- char :" + (char)i);
//        }
    }

    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        char left, right;
        for (int i = 0, j = charArray.length - 1; i < j;) {
            left = charArray[i];
            if (left < '0' || (left > '9' && left < 'A') || (left > 'Z' && left < 'a') || left > 'z') {
                i += 1;
                continue;
            }
            right = charArray[j];
            if (right < '0' || (right > '9' && right < 'A') || (right > 'Z' && right < 'a') || right > 'z') {
                j -= 1;
                continue;
            }
            if (left == right ||
                    (left >= 'a' && left - right == 'a' - 'A') || (right >= 'a' && right - left == 'a' - 'A')) {
                i += 1;
                j -= 1;
                continue;
            }
            return false;
        }
        return true;
    }
}
