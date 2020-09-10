package elementary_algorithm.dynamic_planning;

import util.CommonUtils;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn8fsh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxProfit {
    public static void main(String[] args) {
//        int[] stocks = new int[] {7,6,4,3,1};
        int[] stocks = new int[] {7,1,5,3,6,4};
        MaxProfit entity = new MaxProfit();
        System.out.println("{stocks cost: [" + CommonUtils.array2String(stocks) + "]}, {maxProfit:" + entity.maxProfit(stocks) + "}");
    }

    /***
     * f(x) = max(f(x-1), [x - mix(0~x-1)]) // 不太严谨，理解就行。。。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        try {
            // 我们默认输入合法，size >= 2 所以这里省略了一步判断size <= 1 // 发现测试样本有[] 所以try catch掉少一个判断
            int currentMin = Math.min(prices[0], prices[1]), result = Math.max(0, prices[1] - prices[0]);
            for (int i = 2; i < prices.length; i++) {
                result = Math.max(result, prices[i] - currentMin);
                if (currentMin > prices[i]) {
                    currentMin = prices[i];
                }
            }
            return result;
        } catch (Exception ex) {
            return 0;
        }
    }
}
