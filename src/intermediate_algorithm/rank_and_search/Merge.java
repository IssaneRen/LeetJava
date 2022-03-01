package intermediate_algorithm.rank_and_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * 相关标签
 * 数组
 * 排序
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv11yj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Merge {

    public static void main(String[] args) {
        int[] a = new int[]{2, 3};
        int[] b = new int[]{4, 5};
        int[] c = new int[]{6, 7};
        int[] d = new int[]{8, 9};
        int[] e = new int[]{1, 10};
        int[][] intervals = new int[][]{a, b, c, d, e};

        System.out.println("Merge, 结果=" + Arrays.deepToString((new Merge()).mergeQuick(intervals)));
    }


    // 错误：[[2,3],[4,5],[6,7],[8,9],[1,10]]
    public int[][] merge(int[][] intervals) {
        // 0. 容错，刷题应该不用
        if (intervals == null || intervals.length <= 0) return null;
        // 1. 排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 2. 排序后，逐一插入结果集
        List<int[]> res = new ArrayList<>();
        // 2.1.  // 首先添加第一个
        int[] tmp = intervals[0];
        res.add(tmp);
        for (int i = 0; i < intervals.length - 1; i++) {
            // 2.2. 从左往右数，每一个都判断是不是有交集。访问i的时候其实是尝试添加i+1
            // 2.2.1. 如果左侧落在之前的范围里，开始判断
            if (intervals[i + 1][0] <= tmp[1]) {
                // 2.2.2. 如果i+1直接缩到里面了，跳过
                if (intervals[i + 1][1] <= tmp[1]) {
                    continue;
                } else {
                    // 2.2.3. 如果 i+1 没缩在里面，则覆盖
                    tmp[1] = intervals[i + 1][1];
                }
            } else {
                res.add(intervals[i + 1]);
                tmp = intervals[i + 1];
            }
        }
        // 3. 转换成int[] 返回结果
        return res.toArray(new int[res.size()][]);
    }


    // 错误：[[2,3],[4,5],[6,7],[8,9],[1,10]]
    public int[][] mergeQuick(int[][] intervals) {
        // 0. 容错，刷题应该不用
//        if (intervals == null || intervals.length <= 0) return null;
        // 1. 排序
        Arrays.sort(intervals, ((o1, o2) -> (o1[0] - o2[0])));
        // 2. 排序后，逐一插入结果集
        List<int[]> res = new ArrayList<>();
        // 2.1.  // 首先添加第一个
        int[] tmp = intervals[0];
        res.add(tmp);
        for (int i = 0; i < intervals.length - 1; i++) {
            // 2.2. 从左往右数，每一个都判断是不是有交集。访问i的时候其实是尝试添加i+1
            // 2.2.1. 如果左侧落在之前的范围里，开始判断
            if (intervals[i + 1][0] <= tmp[1]) {
                // 2.2.2. 如果i+1直接缩到里面了，跳过
                if (intervals[i + 1][1] > tmp[1]) {
                    // 2.2.3. 如果 i+1 没缩在里面，则覆盖
                    tmp[1] = intervals[i + 1][1];
                }
            } else {
                res.add(intervals[i + 1]);
                tmp = intervals[i + 1];
            }
        }
        // 3. 转换成int[] 返回结果
        return res.toArray(new int[res.size()][]);
    }
}
