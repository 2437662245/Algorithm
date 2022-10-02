package leetcodetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: zh
 * DateTime: 2022/3/18 15:23
 * Description: "dogs"
 * ["dog","s","gs"]
 */
public class L139 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("dog");
        list.add("s");
        list.add("gs");
        String s = "dogs";
        boolean res = wordBreak(s, list);
        System.out.println(res);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 字符串可以重复使用 -> 完全背包问题
        // 字符串列表中字符串 -> 物品
        // 字符串s -> 背包
        // 背包容量如何界定？   s.length

        // 1. 确定dp数组及含义 dp[i]表示能够拼接出s.substring(0,i+1)
        boolean[] dp = new boolean[s.length() + 1];
        // 2. 初始化dp数组，false，用默认值即可
        dp[0] = true;
        // 3. 确定递推公式 dp[i] = dp[i] || dp[]
        // 4. 确定遍历顺序，单词可以重复使用，所以先遍历背包
        for (int i = 1; i <= s.length(); i++) {               // 遍历背包
            String temp_s = s.substring(0, i);
            for (String word : wordDict) {                    // 遍历物品
                if (i >= word.length() && word.equals(temp_s.substring(temp_s.length() - word.length()))) { // 这个单词是s的尾部字串
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];
    }
}
