package hot_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 @link https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2： 输入：nums = [3,2,4], target = 6 输出：[1,2]
 * 示例 3：输入：nums = [3,3], target = 6  输出：[0,1]
 */
public class No_1_TwoNumSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoNumSum_2(nums, target)));
    }

    private static int[] twoNumSum_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return nums;
        if (nums.length == 1) return (nums[0] == target) ? new int[]{0} : new int[0];
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    private static int[] twoNumSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}
