package intermediate_algorithm.array_and_string;

import util.CommonUtils;

import java.util.*;

/**
 *字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvaszc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("{input: " + CommonUtils.array2String(input) + "},\n {output: " + new GroupAnagrams().groupAnagrams(input) + "}");
//        System.out.println("{hashCode of \"str\": " + "str".hashCode() + "},\n {hashCode of \"trs\" " + "trs".hashCode() + "}");
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> tmpList;
        String tmpString;
        char[] tmpCharArr;
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            tmpCharArr = strs[i].toCharArray();
            Arrays.sort(tmpCharArr);
            tmpString = new String(tmpCharArr);
            tmpList = hashMap.get(tmpString);
            if (tmpList == null) {
                tmpList = new ArrayList<>();
                tmpList.add(strs[i]);
                hashMap.put(tmpString, tmpList);
            } else {
                tmpList.add(strs[i]);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

    private static boolean anagramsStr(String lhs, String rhs) {
        char[] stringA = lhs.toCharArray(), stringB = rhs.toCharArray();
        Arrays.sort(stringA);
        Arrays.sort(stringB);
        return String.valueOf(stringA).equals(String.valueOf(stringB));
    }
}
