package intermediate_algorithm.traceback;

import util.CommonUtils;

import java.util.*;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvkwe2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Exist {
    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
//        String word = "SEE";
//        String word = "ABCB";
//        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        String word = "AAB";
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
//        char[][] board = new char[][]{{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
//        String word = "aaaaaaaaaaaaa";

        System.out.println("TEST PROGRAM: ========== \nword: " + word
                + "\n board:\n " + CommonUtils.array2String(board)
                + "\n exist:  " + new Exist().exist(board, word));

    }

    /**
     * 1. 尝试使用BFS搜索  ---- 失败 改成DFS
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() <= 0) {
            return true;
        }
//        Queue<List<Integer>> queue = new ArrayDeque<>();  // 3个成员的list  {0} -- 对应string位置 {1,2} 对应在board的x/y位置 //bfs
        Stack<List<Integer>> stack = new Stack<>();
        char findingChar = word.charAt(0);
        List<Integer> temp = new ArrayList<>(3);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == findingChar) {
                    if (word.length() == 1)
                        return true;
                    temp.clear();
                    temp.add(0, 0);
                    temp.add(1, i);
                    temp.add(2, j);
                    stack.clear();
                    stack.push(temp);
//                    queue.clear();
//                    queue.offer(temp);
                    if (isRightDotWithDfs(board, word, stack)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean isRightDotWithDfs(char[][] board, String word, Stack<List<Integer>> stack) {
//        // 注意 这里我们假定输入一定合法 即---未越界，且这个xy点一定符合当前条件
//        if (board[x][y] != word.charAt(0)) {
//            return false;
//        }
        List<Integer> temp, tempNext;
        boolean [][] visited = new boolean[board.length][board[0].length];
        temp = stack.peek();
        int toReleaseX, toReleaseY;
        visited[temp.get(1)][temp.get(2)] = true;
        tempNext = getNearestUnvisitedNode(board, temp, visited, word);
        while (!stack.isEmpty()) {
            // 1. 每次循环，首先deep first
            while (tempNext != null) {
                if (tempNext.get(0) == word.length() - 1) {
                    return true;
                }
                visited[tempNext.get(1)][tempNext.get(2)] = true;
                stack.push(tempNext);
                temp = tempNext;
                tempNext = getNearestUnvisitedNode(board, temp, visited, word);
            }
            if (!stack.empty()) stack.pop();
            // 2. 当遇到deep瓶颈时候，回溯  --- 注意，到了这个条件下，一定tempNext为null
            while (!stack.empty() && tempNext == null) {
                toReleaseX = temp.get(1);
                toReleaseY = temp.get(2);
                temp = stack.pop();
                tempNext = getNearestUnvisitedNode(board, temp, visited, word);
                if (tempNext == null) {
                    visited[toReleaseX][toReleaseY] = false;
                }
            }
            if (tempNext != null) {
                stack.push(temp);
            }
        }
        return false;
    }

    public List<Integer> getNearestUnvisitedNode(char[][] board, List<Integer> currentNode, boolean [][] visited, String word) {
        int x = currentNode.get(1), y = currentNode.get(2), currentPosition = currentNode.get(0);
        char temp, toFind = word.charAt(currentPosition + 1);
        List<Integer> result = new ArrayList<>();
        for (int i = -1; i < 2; i+=2) {
            try {
                temp = board[x][y+i];
                if (!visited[x][y+i] && temp == toFind) {
                    visited[x][y+i] = true;
                    result.add(currentPosition + 1);
                    result.add(x);
                    result.add(y+i);
                    return result;
                }
            } catch (Exception e) {
            }
        }
        for (int i = -1; i < 2; i+=2) {
            try {
                temp = board[x+i][y];
                if (!visited[x+i][y] && temp == toFind) {
                    visited[x+i][y] = true;
                    result.add(currentPosition + 1);
                    result.add(x+i);
                    result.add(y);
                    return result;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }


//    public boolean isRightDotWithBfs(char[][] board, String word, Queue<List<Integer>> queue) {
////        // 注意 这里我们假定输入一定合法 即---未越界，且这个xy点一定符合当前条件
////        if (board[x][y] != word.charAt(0)) {
////            return false;
////        }
//        List<Integer> temp;
//        boolean [][] visited = new boolean[board.length][board[0].length];
//        visited[queue.peek().get(1)][queue.peek().get(2)] = true;
//        List<List<Integer>> switcher = new ArrayList<>(); // 用来记录多路径都可以时候的bool值
//        while (!queue.isEmpty()) {
//            temp = queue.poll();
//            if (checkAndAddLegalNode(board, word, queue, temp, visited, switcher)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * @return 这一次添加后，是否就找到了对应的路径
//     */
//    public boolean checkAndAddLegalNode(char[][] board, String word, Queue<List<Integer>> queue, List<Integer> current, boolean[][] visited, List<List<List<Integer>>> switcher) {
//        int findingPosition = current.get(0) + 1;
//        int x = current.get(1), y = current.get(2) ,findCountAtLeastOne = 0;
//        char temp, toFind = word.charAt(findingPosition);
//        boolean isLast = findingPosition == word.length() - 1;
//        List<Integer> tempArray;
//        for (int i = -1; i < 2; i+=2) {
//            try {
//                temp = board[x][y+i];
//                if (!visited[x][y+i] && temp == toFind) {
//                    if (isLast) {
//                        return true;
//                    } else {
//                        if (findCountAtLeastOne > 0) {
//                            addToSwitcher(switcher, current, tempArray);
//                        }
//                        findCountAtLeastOne++;
//                        visited[x][y+i] = true;
//                        tempArray = new ArrayList<>(3);
//                        tempArray.add(0, findingPosition);
//                        tempArray.add(1, x);
//                        tempArray.add(2, y+i);
//                        queue.offer(tempArray);
//                    }
//                }
//            } catch (Exception e) {
//            }
//        }
//        for (int i = -1; i < 2; i+=2) {
//            try {
//                temp = board[x+i][y];
//                if (!visited[x+i][y] && temp == toFind) {
//                    if (isLast) {
//                        return true;
//                    } else {
//                        if (findCountAtLeastOne > 0) {
//                            addToSwitcher(switcher, current, tempArray);
//                        }
//                        findCountAtLeastOne++;
//                        visited[x+i][y] = true;
//                        tempArray = new ArrayList<>(3);
//                        tempArray.add(0, findingPosition);
//                        tempArray.add(1, x+i);
//                        tempArray.add(2, y);
//                        queue.offer(tempArray);
//                    }
//                }
//            } catch (Exception e) {
//            }
//        }
//        if (findCountAtLeastOne == 0) { // 如果这个点一个都没找到 要把这个点的前置回退，把前面的分支点都取消， 当然，取消之后还要把别的分支都赋值
//            visited[x][y] = false;
//        }
//        return false;
//    }
//
//    public void addToSwitcher(List<List<List<Integer>>> switcher, List<Integer> current, List<Integer> toAdd) {
//        List<List<Integer>> currentSwitcher = null;
//        for (List<List<Integer>> switcherCase : switcher) {
//            if (switcherCase.get(switcherCase.size() - 1) == current) {
//                currentSwitcher = switcherCase;
//                break;
//            }
//        }
//        if (currentSwitcher == null) {
//            currentSwitcher = new ArrayList<>();
//            switcher.add(currentSwitcher);
//        }
//        currentSwitcher.add(toAdd);
//    }
//
//    public void deleteRelativeSwitcher(List<List<List<Integer>>> switcher, List<Integer> current) {
//        for (List<List<Integer>> switcherCase : switcher) {
//            if (switcherCase.get(switcherCase.size() - 1) == current) {
//                currentSwitcher = switcherCase;
//                break;
//            }
//        }
//    }
}
