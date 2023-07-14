package hot;

/**
 * @author: joe
 * @dateTime: 2023/4/11 21:55
 * @description: TODO
 * @version: 1.0
 */

public class Hot416 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,10,6};
        canPartition(nums);
    }
    public static boolean canPartition(int[] nums) {
        // 背包问题 0-1背包
        // 某些数的和为sum(nums)/2则可以，否则不可以
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if ((target & 1) == 1) {
            return false;
        }
        target /= 2;
        // Arrays.sort(nums);
        // 某些数的和为target，则true，否则false
        // dfs或者dp
        // dp[i][j]表示前i个数和是否可以为j
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        // dp数组初始化
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {

            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
