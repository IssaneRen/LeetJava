package intermediate_algorithm.mathematics;

/**
 * Excel表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 *  
 *
 * 示例 1:
 *
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: columnTitle = "ZY"
 * 输出: 701
 *  
 *
 * 提示：
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 * 相关标签
 * 数学
 * 字符串
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xweb76/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TitleToNumber {
    public static void main(String[] args) {
        String columnTitle = "ZY";
        System.out.println("TitleToNumber titleToNumber=" + (new TitleToNumber()).titleToNumber(columnTitle));
    }

    public int titleToNumber(String columnTitle) {
        char c;
        int res = 0, pos = 1;
        for (int i = columnTitle.length() - 1 ; i >= 0; i--) {
            c = columnTitle.charAt(i);
            res += ((c -'A' + 1) * pos);
            pos *= 26;
        }
        return res;
    }
}
