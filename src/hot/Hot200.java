package hot;

import org.junit.Test;

/**
 * @ClassName: Hot200
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/14 14:38
 * @Version: 1.0
 */
public class Hot200 {

    @Test
    public void test() {
        char[][] grid = new char[][]{
                {'0', '1', '0'},
                {'1', '0', '1'},
                {'0', '1', '0'}
        };
        System.out.println(numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        // dp dp[i][j]表示左上角为(0,0)，右下角为(i-1, j-1)的网格的岛屿数量
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == '1' && ((i == 1 || (i > 1 && grid[i - 2][j - 1] == '0')) &&
                        (j == 1 || (j > 1 && grid[i - 1][j - 2] == '0')))) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
