package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L498
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/6 21:25
 * @Version: 1.0
 */
public class L498 {

    @Test
    public void test() {
        int[][] mat = new int[][]{{2,3}};
        int[] ints = findDiagonalOrder(mat);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {
        // 遍历第一行和最后一列，在加入该位置元素之前，先将对角线上元素加入结果数组中
        int m = mat.length;
        int[] arr = new int[m * m];
        int index = 0;
        // i表示矩阵中元素横纵坐标之和
        for (int sum = 0; sum <= m + m; sum++) {
            // flag为true则↗, ，flag为false则↙
            if (sum % 2 == 0) {
                // i是横坐标
                for (int i = Math.min(sum, m - 1); i >= 0 && sum - i < m; i--) {
                    arr[index++] = mat[i][sum - i];
                }
            } else {
                for (int i = Math.min(sum, m - 1); sum - i < m && i >= 0; i--) {
                    arr[index++] = mat[sum - i][i];
                }
            }
        }
        return arr;
    }
}
