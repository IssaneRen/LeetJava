package elementary_algorithm.dynamic_planning;

import util.CommonUtils;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Rob {
    public static void main(String[] args) {
//        int[] moneyStoring = new int[]{2, 7, 9, 3, 1};
        int[] moneyStoring = new int[]{1,2,3,1};
        Rob entity = new Rob();
        System.out.println("{moneyStoring : " + CommonUtils.array2String(moneyStoring) + "}, {maxProfit:" + entity.rob(moneyStoring) + "}");
    }

    /**
     * 偷窃方法，可以视为2~n步的上楼梯问题？或者最大子字符串?
     *
     * 根据前面的题目，我这里假设 f(n) 为 不偷n 的前n 家最大偷窃总和
     * 则 f(n) = Max{ f(n-2) + m[n] , f(n-1)}
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        switch (nums.length) {
            case 0:
                return 0;
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
        }
        int f1 = nums[0], f2 = Math.max(nums[0], nums[1]), tmp;
        for (int i = 2; i < nums.length; i++) {
            tmp = f2;
            f2 = Math.max(f1 + nums[i], f2);
            f1 = tmp;
        }
        return f2;
    }
}
