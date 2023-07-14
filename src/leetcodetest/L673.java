package leetcodetest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: L673
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/9 18:34
 * @Version: 1.0
 */
public class L673 {

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        int i = findNumberOfLIS1(nums);
        System.out.println(i);
    }

    public int findNumberOfLIS1(int[] nums) {
        /**
         dp
         最长递增子序列个数。。
         dp[i]记录以nums[i]元素结尾的最大递增长度
         */
        int[] curEndLongest = new int[nums.length];    // 记录以当前元素结尾的最长递增长度
        int[] count = new int[nums.length]; // 记录以当前元素结尾的最长递增序列的个数
        Arrays.fill(curEndLongest, 1);
        Arrays.fill(count, 1);


        for (int i = 1; i < nums.length; i++) {
            // 从当前元素往前找最长递增长度
            for (int j = i - 1; j >= 0; j--) {
                // 如果当前元素大于之前的元素
                if (nums[i] > nums[j]) {
                    // 当前递增长度 <= 前面元素的递增长度
                    if (curEndLongest[i] <= curEndLongest[j]) {
                        curEndLongest[i] = curEndLongest[j] + 1;
                        count[i] = count[j];
                    } else if (curEndLongest[i] == curEndLongest[j] + 1) {
                        // 当前递增长度为前面元素递增长度+1 当前递增长度不变，个数+count[j]
                        count[i] += count[j];
                    }
                }
            }
        }
        int longest = 1;         // 记录最长递增序列长度
        int longestCount = 1;    // 记录最长递增序列个数
        for (int i = 1; i < nums.length; i++) {
            if (curEndLongest[i] > longest) {
                longest = curEndLongest[i];
                longestCount = count[i];
            } else if (curEndLongest[i] == longest) {
                longestCount += count[i];
            }
        }
        return longestCount;
    }


    public int findNumberOfLIS(int[] nums) {
        // 动态规划 dp[i]表示nums中前i+1个元素的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // count[i]表示长度为count的递增子数组的个数
        int[] count = new int[nums.length + 1];
        dp[0] = 1;
        count[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            count[1]++;
            for (int j = i - 1; j >= 0; j--) {
                // 如果当前数可以和之前的数组成更长的子序列 该长度出现的个数+1
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    count[dp[j] + 1]++;
                }
            }
        }
        for (int i = count.length - 1; i >= 1; i--) {
            if (count[i] > 0) {
                return count[i];
            }
        }
        return 0;
    }
}


