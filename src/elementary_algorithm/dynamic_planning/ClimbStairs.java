package elementary_algorithm.dynamic_planning;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn854d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int number = 44;
        ClimbStairs entity = new ClimbStairs();
        System.out.println("{Stairs Layer Number= " + number + "}, {paths number: " + entity.climbStairs(number) + "}");
    }

    /**
     * DFS
     * @param n
     * @return
     */
    public int climbStairs(int n) {
//        if (n == 1) { //如果一共一层楼，那只有一种
//            return 1;
//        }
        return dfsForClimbWithoutDebug(0, n);
    }

    private int dfsForClimb(int startLayer, int topStair) {
        if (startLayer + 1 >= topStair) { // 无论是 差一步到顶，还是 已经到顶，其实都是已经固定了的一条路， 统一处理可以减少循环递归次数
            // todo debug
            if (startLayer == topStair) {
                stringBuilder.append("-> ").append(topStair);
            } else {
                stringBuilder.append("-> ").append(topStair - 1).append("-> ").append(topStair);
            }
            // 完成了一条路径，打印并且清空
            System.out.println("current path route is :{" + stringBuilder.toString() + "}");
            stringBuilder.delete(deleteStart, stringBuilder.length());
            // todo end debug
            return 1;
        }

        // 如果没到顶，是普通的节点
        int pathNumber = 0; // 从这个点，到终点，有这些跳路径
        // todo debug
        stringBuilder.append("-> ").append(startLayer);
        // todo end debug
        // 一步要迈多长 -- step
        for (int step = 1; startLayer + step <= topStair && step <= 2; step++) {
//            if (layerRecordMap.getOrDefault(startLayer + step, false)) { // 如果迈过去那一步的节点被记录了，跳过  // 但是这是线性的，不是图，所以不可能访问过
//                continue;
//            }
            deleteStart = stringBuilder.length();
            int currentPath = dfsForClimb(startLayer + step, topStair);
//            System.out.println("finding path from layer {" + startLayer + "}...... and path number is:{" + currentPath + "}");
            pathNumber += currentPath;
        }
        // todo debug
        stringBuilder.delete(stringBuilder.lastIndexOf("-> "), stringBuilder.length()); // 一次for循环之后 要删除前面的节点退回去
        // todo end debug
        return pathNumber;
    }

    private int dfsForClimbWithoutDebug(int startLayer, int topStair) {
        if (startLayer + 1 >= topStair) { // 无论是 差一步到顶，还是 已经到顶，其实都是已经固定了的一条路， 统一处理可以减少循环递归次数
            return 1;
        }

        // 如果没到顶，是普通的节点
        int pathNumber = 0; // 从这个点，到终点，有这些跳路径
        // 一步要迈多长 -- step
        for (int step = 1; startLayer + step <= topStair && step <= 2; step++) {
            int currentPath = dfsForClimbWithoutDebug(startLayer + step, topStair);
            pathNumber += currentPath;
        }
        return pathNumber;

    }

    private final static StringBuilder stringBuilder = new StringBuilder();
    private static int deleteStart = 0;
}
