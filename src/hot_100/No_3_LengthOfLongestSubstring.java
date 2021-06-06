package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 无重复字符的最长子串 @link https://leetcode-cn.com/problems/two-sum/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1：输入：s = "abcabcbb" 输出：3 解释：因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2： s = "bbbbb" 输出： 1
 * 示例 3：输入：s = "pwwkew" 输出：3
 */
public class No_3_LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        char[] charArr = s.toCharArray();
        List<Character> tempList = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            tempList.clear();
            for (int j = i; j < charArr.length; j++) {
                char c = charArr[j];
                if (!tempList.contains(c)) {
                    tempList.add(c);
                } else {
                    break;
                }
            }
            maxLen = Integer.max(maxLen, tempList.size());
        }
        return maxLen;
    }
}
