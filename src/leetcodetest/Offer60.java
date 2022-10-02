package leetcodetest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/25 19:51
 */
public class Offer60 {

    @Test
    public void listTest() {
        Integer[] arr = new Integer[]{1,2,3};
        List<Integer> integers = Arrays.asList(arr);

        Integer[] array = integers.toArray(new Integer[integers.size()]);
        for (int a : array) {
            System.out.println(a);
        }

        System.out.println(integers);
    }

    @Test
    public void Offer60Test() {
        System.out.println(dicesProbability(2).length);
    }

    public double[] dicesProbability(int n) {
        // 动态规划 dp[i][j] 表示i个筛子点数和为j的概率
        double[][] dp = new double[n + 1][n * 6 + 1];

        // dp数组初始化
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = (double)1 / 6;
        }

        // 确定递推公式 状态转移
        double[] result = new double[n * 6 - n + 1];

        for (int i = 2; i <= n; i++) {  // 筛子个数
            for (int j = i; j <= i * 6; j++) {  // i个筛子 点数为j的概率
                for (int k = 1; k <= Math.min(j - 1, 6); k++) {
                    // 第一个筛子点数为k 其余筛子点数为j-k
                    dp[i][j] += dp[1][k] * dp[i - 1][j - k];
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = dp[n][n + i];
        }




        return result;
    }
}
