package intermediate_algorithm.dynamic_planning;

import java.util.Arrays;

/**
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * 相关标签
 * 广度优先搜索
 * 数组
 * 动态规划
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvf0kh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CoinExchange {
    public static void main(String[] args) {
//        int[] coins = new int[]{1, 2, 5};
//        int amount = 100;
//        int[] coins = new int[]{1};
//        int amount = 1;
//        int[] coins = new int[]{1,2147483647};
//        int amount = 2;
        int[] coins = new int[]{1,2};
        int amount = 2;
//        int[] coins = new int[]{186, 419, 83, 408};
//        int amount = 6249;

        System.out.println("CoinExchange, 结果=" + ((new CoinExchange()).coinChange2(coins, amount)));
    }

    /**
     * 经典的线性规划 。看到题目首先还是想到深度优先遍历简化问题
     * 还有一种思路就是想出递归的f(x)写法
     * f(amount) = min {f(amount - 1)}
     * 用 1，2,5  100 测试
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int minCoin = coins[0];
        return calculateChange(coins, amount, minCoin);

    }

    /**
     * 方法1 - 路径函数，计算到amount的步数
     */
    private int calculateChange(int[] rankedCoins, int amount, final int minCoin) {
        if (amount == 0) return 0;
        if (amount < minCoin) return -1;
        int res = -1, tmp;
        for (int i = rankedCoins.length - 1; i >= 0; i--) {
            tmp = amount - rankedCoins[i];
            if (tmp > 0) {
                tmp = calculateChange(rankedCoins, tmp, minCoin);
                if (tmp > 0) {
                    res = chooseMinCoinNum(res, tmp + 1);
                }
            } else if (tmp == 0) {
                return 1;
            }
        }
        return res;
    }

    private int chooseMinCoinNum(int num1, int num2) {
        if (num1 > 0 && num2 < 0) return num1;
        if (num1 < 0 && num2 > 0) return num2;
        return Math.min(num1, num2);
    }

    /**
     * 上面的方法感觉不错，但是超过了时间限制 - [1,2,5]
     * 100
     * <p>
     * 最后我理了一下，这个东西可能找到第一个最大的硬币就可以了。更小的不需要考虑
     * 改完不超时了，但是还有问题 1,1 -- 原来是循环条件少些了 =
     * <p>
     * 第三次提交依然不对，错误输入：
     * [1,2147483647]
     * 2
     * <p>
     * 少了if
     * <p>
     * 第四次依然有问题，错误数据：
     * [186,419,83,408]
     * 6249
     * （预期结果20）
     * <p>
     * 干脆我们就空间换时间，存放一个数组
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] minChangesArray = new int[amount + 1]; // 最大100多 应该能hold住
        Arrays.sort(coins);
        int minCoin = coins[0];
        if (amount < minCoin) {
            return -1;
        }
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < amount) {
                minChangesArray[coins[i]] = 1;
            } else if (coins[i] == amount) {
                return 1;
            } else break;
        }
        minChangesArray[minCoin] = 1; // 第一位的数据
        for (int i = minCoin; i <= amount; i++) {
            if (minChangesArray[i] <= 0) {
                minChangesArray[i] = calculateChange2(coins, minChangesArray, i, minCoin);
            }
        }
        return minChangesArray[amount];
    }

    private int calculateChange2(int[] rankedCoins, int[] minChangePath, int amount, final int minCoin) {
        int res = -1, tmp;
        for (int i = rankedCoins.length - 1; i >= 0; i--) {
            tmp = amount - rankedCoins[i];
                if (tmp >= minCoin) {
                tmp = minChangePath[tmp];
                if (tmp > 0) {
                    if (res > 0) res = Math.min(res, tmp + 1);
                    else res = tmp +1 ;
                }
            }
        }
        return res;
    }
}
