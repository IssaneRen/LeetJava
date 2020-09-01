package elementary_algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int nums[] = {1,4,3,2};
        System.out.println("result is: " + containsDuplicate(nums));
    }


    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;

        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]))
                return true;
            hashMap.put(nums[i], 1);
        }
        return false;
    }

    /**
     * 提交结果之后，得到的网上答案参考学来的。
     * 感觉 有点作弊
     * 但是简单、高速、占内存少。为啥不试试呢
     * @param nums
     * @return
     */
    public static boolean containsDuplicateLearn(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }
}
