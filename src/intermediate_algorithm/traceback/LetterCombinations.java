package intermediate_algorithm.traceback;

import java.util.*;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * (一张图片：
 *              2 - abc     3 - def
 *   4 - ghi    5 - jkl     6 - mno
 *   7 - pqrs   8 - tuv     9 - wxyz
 * ）
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv8ka1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LetterCombinations {
    public static void main(String[] args) {
//        String input = "233";
        String input = "23";
        System.out.println("TEST PROGRAM: ========== \ninput:\n " + input + "\n letterCombinations:\n " + new LetterCombinations().letterCombinations(input));
    }

    /**
     * dfs 深度优先搜索
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        int length = digits.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        char tempChar;
        boolean findingChar = true;  // 因为我们把char和number一起入栈，所以这个标记我们到底要找什么
        stack.push(digits.charAt(0));
        for (char c : map.get(digits.charAt(0))) {
            stack.push(c);
        }
        int currentCursor = 1;
        while (!stack.empty()) {
            if (!findingChar) {
                if (currentCursor < length) {
                    tempChar = digits.charAt(currentCursor);
                    currentCursor++;
                    stack.push(tempChar);
                    for (char c : map.get(tempChar)) {
                        stack.push(c);
                    }
                } else {
                    result.add(stringBuilder.toString());
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                findingChar = true;
            } else {
                tempChar = stack.pop();
                if (tempChar > '1' && tempChar <= '9') {
                    while (!stack.empty() && tempChar > '1' && tempChar <= '9') { // 回溯
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        currentCursor--;
                        tempChar = stack.pop();
                    }
                    if (tempChar >= 'a' && tempChar <= 'z') {
                        stringBuilder.append(tempChar);
                    }
                } else {
                    stringBuilder.append(tempChar);
                }
                findingChar = false;
            }

        }


        return result;
    }

    public static Map<Character, Character[]> map = new HashMap<>();

    static {
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }
}
