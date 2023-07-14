package hot;

/**
 * @author: joe
 * @dateTime: 2023/2/28 21:54
 * @description: TODO
 * @version: 1.0
 */
public class Hot07 {
    public static void main(String[] args) {
        int i = reverse(-2147483648);
        System.out.println(i);
    }
    public static int reverse(int x) {
        // int flag = x < 0 ? -1 : 1;
        int res = 0;

        while (x != 0) {
            // 边界判断
            if ((res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) && x != 0) {
                return 0;
            }
            if (res == Integer.MAX_VALUE / 10 && (x > 7 || x <= -8)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
