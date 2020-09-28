package intermediate_algorithm.traceback;

import util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv67o6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Subsets {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        System.out.println("TEST PROGRAM: ========== \ninput: " + CommonUtils.array2String(input)
                + "\n permute:\n " + new Subsets().subsets(input)
                + "\n count:  " + new Subsets().subsets(input).size());

    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return  new ArrayList<List<Integer>>();
        }
        return subsets(nums, nums.length);
    }

    public List<List<Integer>> subsets(int[] nums, int last) {
//        if (start < 0 || last >= nums.length) { // 算法题不需要加鲁棒性
//            return null;
//        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempArray, tempArray2;
        /*if (start(0) >= last) {  // 算法题不需要加鲁棒性
            return null;
        } else */
        if (last == 1) {
            tempArray = new ArrayList<>();
            tempArray.add(nums[0]);
            result.add(tempArray);
            result.add(new ArrayList<>());
            return result;
        }
        result = subsets(nums, last - 1);
        int insert = nums[last - 1], lastSize = result.size() ;
        for (int i = 0; i < lastSize; i++) {
            tempArray = result.get(i);
            tempArray = new ArrayList<>(tempArray);
            tempArray.add(insert);
            result.add(tempArray);
        }
        return result;
    }
}
