package scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/27 20:12
 * @description: TODO
 * @version: 1.0
 */
import org.junit.Test;

import java.util.*;
public class HJ18 {
    static int[] count = new int[7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] str = s.split("~");
            String ipStr = str[0];
            String ymStr = str[1];
            if (!ymVaild(ymStr)) {
                count[5]++;
            } else {
                ipValid(ipStr);
            }
        }
        for (int i : count) {
            System.out.println(i);
        }
    }

    // 判断ip的合法性和类别 A类0 B类1 C类2 D类3 E4 错5 私有6
    public static void ipValid(String ipStr) {
        String[] strs = ipStr.split("\\.");
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }

        if (arr[0] >= 1 && arr[0] < 127) {
            count[0]++;   // A类
            if (arr[0] == 10) {
                count[6]++;
            }
        } else if (arr[0] >= 128 && arr[0] < 192) {
            count[1]++;   // B类
            if (arr[0] == 127 && arr[1] >= 16 && arr[1] <= 31) {
                count[6]++;
            }
        } else if (arr[0] >= 192 && arr[0] < 224) {
            count[2]++;   // C类
            if (arr[0] == 192 && arr[1] == 168) {
                count[6]++;
            }
        } else if (arr[0] >= 224 && arr[0] < 240) {
            count[3]++;   // D类
        } else if (arr[0] >= 240 && arr[0] < 256) {
            count[4]++;   // E类
        } else {
            count[5]++;
        }


    }

    // 判断掩码的合法性
    @Test
    public void ymVaild() {
        System.out.println(ymVaild("255.255.255.255"));
    }

    public static boolean ymVaild(String ymStr) {
        // 二进制运算啊！
        boolean allOne = false;

        String[] strs = ymStr.split("\\.");
        // 从后向前 如果出现过1，就不能再出现0了
        for (int i = 3; i >= 0; i--) {
            int m = Integer.valueOf(strs[i]);
            while (m > 0) {
                if ((m & 1) == 1) {
                    allOne = true;  // 之后的全部都要1了
                } else if ((m & 1) == 0 && allOne) {
                    return false;
                }
                m = m >> 1;
            }
        }
        // 全是1时，为非法掩码
        if (Integer.valueOf(strs[3]) == 255) {
            return false;
        }
        return true;
    }
}