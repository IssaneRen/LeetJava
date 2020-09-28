package intermediate_algorithm.traceback;

import util.CommonUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvqup5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Permute {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4};
        System.out.println("TEST PROGRAM: ========== \ninput: " + CommonUtils.array2String(input)
                + "\n permute:\n " + new Permute().permute(input)
                + "\n count:  " + new Permute().permute(input).size());

    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return  new ArrayList<List<Integer>>();
        }
        return permute(nums, 0, nums.length);
    }

    public List<List<Integer>> permute(int[] nums, int start, int last) {
//        if (start < 0 || last >= nums.length) { // 算法题不需要加鲁棒性
//            return null;
//        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempArray, tempArray2;
        /*if (start >= last) {  // 算法题不需要加鲁棒性
            return null;
        } else */if (start == last - 1) {
            tempArray = new ArrayList<>();
            tempArray.add(nums[start]);
            result.add(tempArray);
            return result;
        }
        result = permute(nums, start, last - 1);
        int insert = nums[last - 1], lastSize = result.size(), lastSingleLength = result.get(0).size();
        for (int i = 0; i < lastSize; i++) {
            tempArray = result.get(i);
            for (int insertPosition = 0; insertPosition <= lastSingleLength; insertPosition++) {
                if (insertPosition != lastSingleLength) {
                    tempArray2 = new ArrayList<>(tempArray);
                    tempArray2.add(insertPosition, insert);
                    result.add(tempArray2);
                } else {
                    tempArray.add(insertPosition, insert);
                }
            }
        }
        return result;
    }
}
