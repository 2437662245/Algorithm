package leetcodetest;

import java.util.Arrays;

/**
 * Auther: zh
 * DateTime: 2022/3/20 20:03
 * Description:
 */
public class L300 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,2,3};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
    public static int lengthOfLIS(int[] nums) {
        // dp
        int max = 0;
        // 1. 明确dp数组及其含义 dp[i] 表示数组中前i个元素中最长严格递增子序列长度
        int[] dp = new int[nums.length];
        // 2. 初始化dp数组
        // dp[0] = 1;
        // 3. 明确递推公式 状态转移
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
        }
        return max;
    }
}
