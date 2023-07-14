package hot;

import org.junit.Test;

/**
 * @ClassName: Hot79
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/7 20:39
 * @Version: 1.0
 */
public class Hot79Test {

    @Test
    public void test() {
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCB";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        // 思路：动态规划 dp[k][i][j]标识board[i][j]能够构成word[0,k]各字符
        int m = board.length, n = board[0].length;
        char[] chars = word.toCharArray();
        int len = chars.length;
        boolean[][][] dp = new boolean[len][m][n];

        for (int k = 0; k < len; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == chars[k]) {
                        if (k == 0) {
                            dp[k][i][j] = true;
                            continue;
                        }

                        if (i > 0) {
                            dp[k][i][j] = dp[k][i][j] || dp[k - 1][i - 1][j];
                        }
                        if (i < m - 1) {
                            dp[k][i][j] = dp[k][i][j] || dp[k - 1][i + 1][j];
                        }
                        if (j > 0) {
                            dp[k][i][j] = dp[k][i][j] || dp[k - 1][i][j - 1];
                        }
                        if (j < n - 1) {
                            dp[k][i][j] = dp[k][i][j] || dp[k - 1][i][j + 1];
                        }
                        if ((k == len - 1) && dp[k][i][j]) {
                            for (int x = 0; x < k; x++) {
                                if (dp[x][i][j]) {
                                    continue;
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
