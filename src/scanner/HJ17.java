package scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/27 18:29
 * @description: TODO
 * @version: 1.0
 */
import java.io.*;
import java.util.*;
public class HJ17 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // 定义横纵坐标
        int row = 0, col = 0;
        String[] strs = reader.nextLine().split(";");
        for (String str : strs) {
            if (!str.matches("[AWSD][1-9][0-9]")) {
                continue;
            }
            // 判断是否是合法字符串
            if (str.charAt(0) == 'A') {
                row -= Integer.valueOf(str.substring(1, str.length()));
            } else if (str.charAt(0) == 'D') {
                row += Integer.valueOf(str.substring(1, str.length()));
            } else if (str.charAt(0) == 'S') {
                col -= Integer.valueOf(str.substring(1, str.length()));
            } else if (str.charAt(0) == 'W') {
                col += Integer.valueOf(str.substring(1, str.length()));
            }
        }
        String res = row  + "," + col;
        System.out.println(res);
    }
    // 返回字符串是否是合法坐标
    public static boolean isVaild(String str) {
        if ("".equals(str) || str.length() > 3 || str.length() < 2) {
            return false;
        }
        if (str.charAt(0) != 'A' && str.charAt(0) != 'S' &&
                str.charAt(0) != 'W' && str.charAt(0) != 'D' ) {
            return false;
        }
        if (str.charAt(1) < '1' || str.charAt(1) > '9') {
            return false;
        }
        if (str.length() == 3 && (str.charAt(2) < '0' || str.charAt(2) > '9')) {
            return false;
        }
        return true;
    }

}