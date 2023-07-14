package exam.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZhouHao
 * @version 1.0
 * @description TODO
 * @date 2023/3/11 20:27
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charsD = sc.nextLine().toCharArray();
        char[] charsW = sc.nextLine().toCharArray();
        // 四个方向 up down left right
        char[][] chars = new char[16][16];
        int dx= 0;
        int dy = 0;
        for (char[] as : chars) {
            Arrays.fill(as, '.');
        }
        chars[0][0] = 'R';
        chars[15][15] = 'L';
        int wx = 15;
        int wy = 15;

        for (int i = 0; i < charsD.length; i++) {
            // 遍历所有的指令
            // 情况1，有人要开火，先检查是否打中对方坦克
            // 情况2，没人开火，都是移动，移动时要判断是否撞到对方
            if (charsD[i] == 'F') {
                // 检查小D是否打中小W  往右打，打中 在同一行，并且小D在左边时，才打中
                if ((chars[dx][dy] == 'R' && dx == wx && dy < wy) ||
                    (chars[dx][dy] == 'D' && dx < wx && dy == wy)) {
                    System.out.println(i + 1);
                    System.out.println('D');
                    return;
                }
            } else if (charsW[i] == 'F') {
                // 检查小W是否打中小D  往右打，打中 在同一行，并且小D在左边时，才打中
                if ((chars[dx][dy] == 'L' && dx == wx && dy < wy) ||
                        (chars[dx][dy] == 'U' && dx < wx && dy == wy)) {
                    System.out.println(i + 1);
                    System.out.println('W');
                    return;
                }
            } else {
                if (charsD[i] == 'R') {
                    if (dy + 1 < 16 && chars[dx][dy + 1] == '.') {
                        chars[dx][++dy] = 'R';
                    } else {
                        chars[dx][dy] = 'R';
                    }
                } else if (charsD[i] == 'D') {
                    if (dx + 1 < 16 && chars[dx + 1][dy] == '.') {
                        chars[++dx][dy] = 'D';
                    } else {
                        chars[dx][dy] = 'D';
                    }
                }

                if (charsD[i] == 'L') {
                    if (dy - 1 >= 0 && chars[dx][dy - 1] == '.') {
                        chars[dx][--dy] = 'L';
                    } else {
                        chars[dx][dy] = 'L';
                    }
                } else if (charsD[i] == 'U') {
                    if (dx - 1 >= 0 && chars[dx - 1][dy] == '.') {
                        chars[--dx][dy] = 'U';
                    } else {
                        chars[dx][dy] = 'U';
                    }
                }
                if (dx == wx && dy == wy) {
                    System.out.println(i + 1);
                    System.out.println('P');
                    return;
                }
            }
        }
        System.out.println(256);
        System.out.println('P');
    }
}
