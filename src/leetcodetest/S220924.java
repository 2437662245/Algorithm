package leetcodetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/24 17:01
 */
public class S220924 {
    public static void main(String[] args) {
        S220924Solution solution = new S220924Solution();
        int num = 4;
        String[] plate = new String[]{"..E.",".EOW","..W."};
        System.out.println(solution.ballGame(num, plate));
    }
}

class S220924Solution {
    // 回溯
    public int[][] ballGame(int num, String[] plate) {
        List<int[]> path = new ArrayList<>();
        // 寻找入口
        int row = plate.length;         // 行数
        int col = plate[0].length();    // 列数
        for (int i = 0; i < row; i++) {    // 第i行 第一列和最后一列
            if (plate[i].charAt(0) == '.' && backtrack(num, plate, i, 0, -99, -99)) {
                path.add(new int[]{i, 0});
            }
            if (plate[i].charAt(col - 1) == '.' && backtrack(num, plate, i, col - 1, -99, -99)) {
                path.add(new int[]{i, col - 1});
            }
        }
        for (int i = 0; i < col; i++) {    // 第i列 第1行和最后一行
            if (plate[0].charAt(i) == '.' && backtrack(num, plate, 0, i, -99, -99)) {
                path.add(new int[]{0, i});
            }
            if (plate[row - 1].charAt(i) == '.' && backtrack(num, plate,row - 1, i, -99, -99)) {
                path.add(new int[]{row - 1, i});
            }
        }

        int[][] result = new int[path.size()][2];
        for (int i = 0; i < path.size(); i++) {
            result[i] = path.get(i);
        }
        return result;
    }

    public boolean backtrack(int num, String[] plate, int row, int col, int lastRow, int lastCol) {
        // 如果步数到达上限 返回
        if (num < 0) {
            return false;
        }
        // 如果出界 行出界 列出界 返回
        if (row >= plate.length || col >= plate[0].length()) {
            return false;
        }

        // 当前位置的字符
        char c = plate[row].charAt(col);
        // 如果这里是洞就返回
        if (c == 'O') {
            return true;
        } else if (c == 'W') {  // 只能往左走
            // 根据从来的方向不同 去的方向也不同
            if ((lastRow == row - 1 && lastCol == col) && col + 1 < plate[0].length()) { // 从上面来的 往右走
                return backtrack(num - 1, plate, row, col + 1, row, col);
            }
            if ((lastRow == row + 1 && lastCol == col) && col - 1 >= 0) { // 从下面来的 往右走
                return backtrack(num - 1, plate, row, col - 1, row, col);
            }
            if ((lastRow == row && lastCol == col + 1) && row + 1 < plate.length) { // 从右面来的 往上走
                return backtrack(num - 1, plate, row + 1, col, row, col);

            }
            if ((lastRow == row && lastCol == col - 1) && row - 1 >= 0) { // 从左边来的 往下走
                return backtrack(num - 1, plate, row - 1, col, row, col);
            }
        } else if (c == 'E') {  // 只能往右走
            // 根据从来的方向不同 去的方向也不同
            if (lastRow == row - 1 && lastCol == col) { // 从上面来的 往左走
                return backtrack(num - 1, plate, row, col - 1, row, col);
            }
            if (lastRow == row + 1 && lastCol == col) { // 从下面来的 往右走
                return backtrack(num - 1, plate, row, col + 1, row, col);
            }
            if (lastRow == row && lastCol == col + 1) { // 从右面来的 往上走
                return backtrack(num - 1, plate, row - 1, col, row, col);
            }
            if (lastRow == row && lastCol == col - 1) { // 从左边来的 往下走
                return backtrack(num - 1, plate, row + 1, col, row, col);
            }
        } else {                // 如果是.可以往三个方向走 不能往来的方向走 不然成死循环了
            boolean s1 = false, s2 = false, s3 = false, s4 = false;
            if (row + 1 != lastRow || lastCol != col) {
                s1 = backtrack(num - 1, plate, row + 1, col, row, col);
            }
            if ((row - 1 != lastRow || lastCol != col) && row > 0) {
                s2 = backtrack(num - 1, plate, row - 1, col, row, col);
            }
            if (row != lastRow || lastCol != col + 1) {
                s3 = backtrack(num - 1, plate, row, col + 1, row, col);
            }
            if ((row != lastRow || lastCol != col - 1) && col > 0) {
                s4 = backtrack(num - 1, plate, row, col - 1, row, col);
            }
            return s1 || s2 || s3 || s4;
        }
        return false;
    }

}
