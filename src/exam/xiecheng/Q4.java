package exam.xiecheng;

/**
 * @author: joe
 * @dateTime: 2023/3/7 15:08
 * @description: TODO
 * @version: 1.0
 */
import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 每条边上，有n-2个+3次的，总共有(n-2) * 4个+3次的
        long res = 0;
        long end = n * n;
        for (int i = 1; i <= 4; i++) {
            res += i * 2;
        }
        for (int i = 5; i <= n * 4 - 4; i++) {
            res += i * 3;
            res = (long) (res % (1e9 + 7));
        }
        for (int i = n * 4 - 3; i <= end; i++) {
            res += i * 4;
            res = (long) (res % (1e9 + 7));
        }
        System.out.println(res);
    }


}
