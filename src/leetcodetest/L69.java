package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L69
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/28 15:47
 * @Version: 1.0
 */
public class L69 {

    @Test
    public void test() {
        mySqrt(10000);
    }

    public int mySqrt(int x) {
        // 二分
        int left = 0;
        int right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
