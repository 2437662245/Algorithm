import org.junit.Test;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/28 19:55
 */
public class OfferTwo002 {


    private static final int BOUND = Integer.MIN_VALUE >> 1;

    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return int
     */
    @Test
    public int divide(int dividend, int divisor) {
        // int 型整数的除法只有一种情况会导致溢出，即（-2^31）/(-1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 特殊情况，无需计算，直接返回
        if (dividend == 0 || divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return -dividend;
        }
        // 由于（-2^31） 转换为正数会溢出，但是任意正数转换为负数都不会溢出
        // 故，记录负数的个数，并将正数转换为负数方便统一计算
        int negative = 2;
        if (dividend > 0) {
            negative--;
            // 将 dividend 置为负
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            // 将 divisor 置为负
            divisor = -divisor;
        }
        int result = divideCore(dividend, divisor);
        // 如果负数的个数是 1 个，结果为负；否则，结果为正
        return negative == 1 ? -result : result;
    }

    private int divideCore(int dividend, int divisor) {
        // 被除数 == 除数，直接返回结果为 1
        if (dividend == divisor) {
            return 1;
        }
        // 开始正式计算
        int result = 0;
        int shift = getMaxShift(divisor, dividend);
        while (dividend <= divisor) {
            while (dividend > (divisor << shift)) {
                shift--;
            }
            dividend -= (divisor << shift);
            result += (1 << shift);
        }
        return result;
    }

    private int getMaxShift(int num, int min) {
        // num 是除数，min 是被除数，希望找到 num << shift < min 时，shift 的最大值
        int shift = 0;
        int temp = num;
        while (temp > min && temp >= BOUND) {
            temp <<= 1;
            shift++;
        }
        return shift;
    }
}
