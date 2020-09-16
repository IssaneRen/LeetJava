package elementary_algorithm.others;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnbcaj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsValidBrace {
    public static void main(String[] args) {
//        String input = "([)]";
        String input = "]]";
        System.out.println("{input: " + input + "}, {output: " + new IsValidBrace().isValid(input) + "}");
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c, checkChar;
        try {
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')') {
                    checkChar = stack.pop();
                    if (checkChar != '(') {
                        return false;
                    }
                } else if (c == ']') {
                    checkChar = stack.pop();
                    if (checkChar != '[') {
                        return false;
                    }
                } else if (c == '}') {
                    checkChar = stack.pop();
                    if (checkChar != '{') {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return stack.empty();
    }
}
