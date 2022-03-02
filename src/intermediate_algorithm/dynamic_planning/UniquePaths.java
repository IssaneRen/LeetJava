package intermediate_algorithm.dynamic_planning;

import java.util.Stack;

/**
 * 不同路径
 * 一个机器人位于一个 m x n  网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * 相关标签
 * 数学
 * 动态规划
 * 组合数学
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvjigd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class UniquePaths {
    public static void main(String[] args) {
//        int m = 23, n = 12;
        int m = 100, n = 2;
        System.out.println("UniquePaths, 结果=" + (new UniquePaths()).uniquePaths3(m, n));
    }

    /**
     * 第一次尝试，看到这种问题第一时间想到深度优先搜索。
     */
    public int uniquePaths(int m, int n) {
        return calculatePath(0,0,m-1, n-1);
    }

    private int calculatePath(final int positionX, final int positionY, final int targetX, final int targetY) {
        if (positionX == targetX && positionY == targetY) return 1;
        int pathNum = 0;
        if (positionX < targetX) {
            pathNum += calculatePath(positionX + 1, positionY, targetX, targetY);
        }
        if (positionY < targetY) {
            pathNum += calculatePath(positionX, positionY + 1, targetX, targetY);
        }
        return pathNum;
    }

    /**
     * 第一次尝试居然超时了。看来必须得用非递归才能满足要求
     */
    public int uniquePaths2(int m, int n) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        int[] tmpNode;
        int pathRes = 0;
        while (!stack.empty()) {
            tmpNode = stack.pop();
            if (tmpNode[0] == m -1 && tmpNode[1] == n -1) {
                pathRes++;
                continue;
            }
            if (tmpNode[0] < m - 1) {
                stack.push(new int[]{tmpNode[0] + 1, tmpNode[1]});
            }
            if (tmpNode[0] < n - 1) {
                stack.push(new int[]{tmpNode[0], tmpNode[1] + 1});
            }
        }
        return pathRes;
    }

    /**
     * 又太大了。这么一看，深度优先搜索真的8行，毕竟只是找路径.
     * 灵机一动 直接数学题
     */
    public int uniquePaths3(int m, int n) {
        return comb( m+n-2, Math.min(m, n) - 1);
    }
    private static int comb(int m,int n){
        double upper = 1, downer = 1;
        for (int i = 0; i < n; i++) {
            upper *= (m - i);
            downer *= (n - i);
        }
        return (int)(upper / downer);
    }
}
