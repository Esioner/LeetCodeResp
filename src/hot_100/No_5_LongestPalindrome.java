package hot_100;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。
 * 示例 2：输入：s = "cbbd" 输出："bb"
 * 示例 3：输入：s = "a" 输出："a"
 * 示例 4：输入：s = "ac" 输出："a"
 * 提示：1 <= s.length <= 1000 、s 仅由数字和英文字母（大写和/或小写）组成
 */
public class No_5_LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babadb"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome("dumpyxybklgdwxbmhptxdckihigddiqzcyvhjhxdekozqxkwaiassrxalcnrlqjbakekgkbpsznmxfvdlhjuokdvzuetuoargsrrfboenozkrglrjnmlsntrxafvqfjniugdzxeutyjybdqfyqmqlkhgvryuwegoibobkstpirzdaspjyxddnyniaywgziqbmkwqaotxirlimlhiuxoyxwsnnmsyzpfxlatnpdqvbiafzqkfssetleiobwwpubzumgittqtrjzeioxkrujkdgzfykyypvnpsxnouxeeqmarjploacjntpixpglugxtiwycmeywhnjyqsmbgxchhtlpjesmhoaskatbfvqodtboozgwlpqclkigpqzvatavdzvgoibmygjsskynldvxevbprdxzpqcpuokyqyseyrekoiipoytftnwqawykfpcqriuazjoqucjkyknmcbiykqerpxxdkqlxvlijqegpexvylgkqygbgkicwmplnwubjwqnarulzlbrdftmzyrzhrmfqoiwzlncdreqaiipnqlwffxircopksnwizmyvzfphlqlvqpcsfjmyssrheczllgkvnretmtixoibncraddatreejidxilnplcrufhdgktvkzuaggcumykgklypodjrpdpjcneagjfxahtjeurotkufkmxsoelzpttfeugdculuxjddghlisdytyjwwnftjbvrwyntqwqjrwlfynczndjyiyaxozdlgdzjseyfumvxuclmszawzwiunwqouycmfgkpzgivsemxamnfjzcabkgkgxcruqhpbkzhpdrcexnioaxbjwxbuipnjbsujajpnqeckfgxyuydytrfhhwsxfjeahpiaoojdwkzstnxflxddljpbhfirteejbtcxpvwutsgrrjv"));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        String resultStr = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char first = arr[i];
            sb.delete(0, sb.length());
            for (int j = i; j < arr.length; j++) {
                sb.append(arr[j]);
                if (first == arr[j] && sb.length() > resultStr.length() && isValid(sb.toString())) {
                    resultStr = sb.toString();
                }
            }
        }
        if ("".equals(resultStr)) resultStr += arr.length > 0 ? arr[0] : "";
        return resultStr;
    }

    private static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        int firstIdx = 0;
        int lastIdx = arr.length - 1;
        while (true) {
            if (arr[lastIdx] != arr[firstIdx]) return false;
            if (firstIdx >= lastIdx) return true;
            firstIdx++;
            lastIdx--;
        }
    }
}
