package intermediate_algorithm.tree_gragh;

import util.CommonUtils;

/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvtsnm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumIslands {
    public static void main(String[] args) {
//        char[][] input = new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}};
//        char[][] input = new char[][]{
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}};
        char[][] input = new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};
        System.out.println("input:\n" + CommonUtils.array2String(input) + "\n ----- numIslands: " + new NumIslands().numIslands1(input));
    }

    /**
     * 方法1 使用DFS
     * 需要设置遍历标记 --- [0,1] 未被遍历 [2] 遍历过的一块岛屿的发源地  [3] 遍历过的一块岛屿的连接处
     * todo 找出更高效的提交
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0] == null || grid[0].length <= 0) {
            return 0;
        }
        int result = 0, height = grid.length, width = grid[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    result++;
                    dfsMarkIsland(grid, i, j);
                }
            }
        }
        return result;
    }

    public static final int[] vector = new int[]{-1, 1};

    public void dfsMarkIsland(char[][] grid, int x, int y) {
//        if (grid == null) {
//            return 0;
//        }
        for (int i = 0; i < 2; i++) {
            int nextY = y + vector[i];
            try {
                if (grid[x][nextY] == '1') {
                    grid[x][nextY] = '2';
                    dfsMarkIsland(grid, x, nextY);
                }
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 2; i++) {
            int nextX = x + vector[i];
            try {
                if (grid[nextX][y] == '1') {
                    grid[nextX][y] = '2';
                    dfsMarkIsland(grid, nextX, y);
                }
            } catch (Exception e) {
            }
        }
    }
}
