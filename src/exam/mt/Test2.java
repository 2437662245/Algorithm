package exam.mt;

import java.util.Scanner;

/**
 * @author ZhouHao
 * @version 1.0
 * @description
 * @date 2023/3/11 19:11
 * 三个参数：n行m列 移动花费：k
 * 每个格子可能R B两种颜色， 如果移动到不同颜色的格子，需要花费k
 * 只能往下、右移动
 * 问最大金币数是多少
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 行
        int n = sc.nextInt();
        // 列
        int m = sc.nextInt();
        // 不同格子间移动 花费金币
        int k = sc.nextInt();
        sc.nextLine();
        char[][] chars = new char[n][m];
        int[][] money = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            chars[i] = line.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                money[i][j] = sc.nextInt();
            }
        }
        // 动态规划 dp[i][j]表示 走到第[i][j]位置上会得到的金币数

        int[][] dp = new int[n][m];
        // dp数组初始化
        dp[0][0] = money[0][0];
        int res = money[0][0];

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + money[0][i];
            if (chars[0][i] != chars[0][i - 1]) {
                dp[0][i] -= k;
            }
            if (dp[0][i] < 0) {
                break;
            }
            res = Math.max(res, dp[0][i]);
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + money[i][0];
            if (chars[i - 1][0] != chars[i][0]) {
                dp[i][0] -= k;
            }
            if (dp[i][0] < 0) {
                break;
            }
            res = Math.max(res, dp[i][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 当前位置可以是从上面来，也可以是从左面来
                // 计算从上面来的收益
                int top = dp[i - 1][j] + money[i][j];
                if (chars[i - 1][j] != chars[i][j]) {
                    top -= k;
                }
                // 计算从左面来的收益
                int left = dp[i][j - 1] + money[i][j];
                if (chars[i][j-1] != chars[i][j]) {
                    left -= k;
                }

                // 取最大的
                int max = Math.max(left, top);
                // 钱不够
                if (max < 0) {
                    System.out.println(res);
                    return;
                }
                dp[i][j] = max;
                res = Math.max(res, dp[i][j]);
            }
        }
        System.out.println(res);
    }
}
