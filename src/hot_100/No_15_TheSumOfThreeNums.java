package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1： 输入：nums = [-1,0,1,2,-1,-4] 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2： 输入：nums = [] 输出：[]
 * 示例 3： 输入：nums = [0] 输出：[]
 */
public class No_15_TheSumOfThreeNums {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{}));
        System.out.println(threeSum(new int[]{0}));
        System.out.println(threeSum(new int[]{3, 0, -2, -1, 1, 2}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        // 排序
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int len = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            if (nums[first] > 0) break; // 因为是已经排过序的，当第一个数都大于0了，后续的所有数也不可能有符合条件的
            // 去重
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int third = len - 1;
            int target = -1 * nums[first];
            for (int second = first + 1; second < len; second++) {
                // 去重
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                while (second < third && nums[second] + nums[third] > target) third--;
                if (second == third) break;
                if (nums[second] + nums[third] == target) {
                    results.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return results;
    }
}
