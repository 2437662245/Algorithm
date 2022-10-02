package leetcodetest;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/18 21:20
 */
public class Offer43 {
    public static void main(String[] args) {
        Offer43Solution offer43Solution = new Offer43Solution();
        int countDigitOne = offer43Solution.countDigitOne(1410065408);
        System.out.println(countDigitOne);
    }
}

class Offer43Solution {
    public int countDigitOne(int n) {
        if (n <= 9) {
            return 1;
        }
        // 统计每一位上出现的1的次数 12
        int base = 1;
        int count = 0;

        int cur = 0;    // 当前位置的数字
        int high = 0;   // 高位的数
        int low = 0;    // 低位的数
        while (n >= base) {
            // 当前位置的数字为
            cur = n / base % 10;
            high = n / base / 10;
            low = n % base;

            if (cur < 1) {
                count += high * base;
            } else if (cur == 1) {
                count += high * base + low + 1;
            } else {
                count += (high + 1) * base;
            }

            // // 当前这个位置上的数小于1 为0
            // if ((n / base) % 10 < 1) {
            //     // n/base/10为当前位置高位的数  base为低位可能出现的数字组合数
            //     count += (n / base / 10) * base;
            // } else if ((n / base) % 10 == 1) {
            //     count += (n / base / 10) * base + (n % base + 1);
            // } else {    // 当前位置大于1的情况
            //     count += (n / base / 10 + 1) * base;
            // }

            base *= 10;
        }
        return count;
    }
}