package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L400
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/14 15:56
 * @Version: 1.0
 */
public class L400 {
    @Test
    public void test() {
        int digit = findNthDigit(1000000000);
        System.out.println(digit);
    }


    public int findNthDigit(int n) {
        // 1 2 3 4 5 6 7 8 9
        // 10 11 12 13 14 15 16 17 18 19
        // 20 21 22 23 24 25 26 27 28 29
        //  ，三位999
        /**
         一位9个
         二位90*2个
         三位900*3
         四位9000*4个
         ...
         */
        // 首先确定 所在数字是几位数，确定是几，再确定是这个数字的第几位
        long sum = 0;
        int count = 1;
        long base = 1;
        while (sum < n - 9 * base * count) {
            sum += 9 * base * count;
            count++;
            base *= 10;
        }
        // 上面while循环完，count就是n所在数的位数，base是此位数的第一个数字 在第n-sum个数上
        // 在count位数上，是第多少位
        int remain = (int)(n - sum);
        // 在count位数上，第n位的是哪个数  remain / count表示是这一位的第几个数，base-1是上一位的最后一个数
        int num = (int)(remain / count + base - 1);
        if (remain % count != 0) {
            num++;
        }
        // 求在这个数的哪一位上 (remain / count - 1)是和这个位数相同的数 nums前面还有多少数
        int k = remain - (int)(num - base) * count;
        // 下面就是求num这个数的第k位上的数，就是结果
        for (int i = count; i > k; i--) {
            num /= 10;
        }
        return num % 10;
    }
}
