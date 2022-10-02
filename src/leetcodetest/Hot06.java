package leetcodetest;

import org.junit.Test;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/30 22:05
 */
public class Hot06 {


    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 根据行数判断能够形成多少个半z 每 numRows*2-2个字符需要numRows-1列 放到二位数组中 再取出拼接
        int sLen = s.length();
        int n = (sLen / (numRows * 2 - 2) + 1) * (numRows - 1); // 列数
        char[][] chars = new char[numRows][n];

        int index = 0;  // s的
        int col = 0;
        while (index < sLen) {
            // 每一列
            for (int i = 0; i < numRows; i++) { // 每一行
                if (index >= sLen) {
                    break;
                }
                chars[i][col] = s.charAt(index++);
            }
            //
            for (int i = numRows - 2; i > 0; i--) {
                if (index >= sLen) {
                    break;
                }
                chars[i][++col] = s.charAt(index++);
            }
            col++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                sb.append(chars[i][j]);
            }
        }
        return sb.toString();
    }
}
