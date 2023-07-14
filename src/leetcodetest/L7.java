package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L7
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/29 14:49
 * @Version: 1.0
 */
public class L7 {

    @Test
    public void test() {
        int reverse = reverse(1463847412);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        /**
         借助字符串

         */

        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        // flag标识x是否为负数 负数为true 正数为false
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x *= -1;
        }
        char[] chars = String.valueOf(x).toCharArray();

        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            // 几种越界情况：
            // 1. res已经大于Integer.MAX_VALUE / 10了，那么当前字符无论是什么，加上去都会越界
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (res == Integer.MAX_VALUE / 10) {
                // 2. res == Integer.MAX_VALUE / 10时
                // 2.1 是负数，而且要小于最小的负数 或者 是正数，并且要大于最大的正数
                if ((chars[i] > '8' && flag) || (!flag && chars[i] > '7')) {
                    return 0;
                }
            }
            res = res * 10 + chars[i] - '0';
        }

        return flag ? res * -1 : res;
    }
}
