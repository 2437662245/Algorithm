package exam.xiecheng;

import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/3/7 15:28
 * @description: TODO
 * @version: 1.0
 */
public class Q4A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long u = n * n;
        int mod = (int) 1e9 + 7;
        long len = (u - (n - 1) * 4) % mod;
        long res = (((2 * u - len + 1)) % mod * len * 2) % mod;
        long le = u - len - 4;
        long prenum = (u - len + 5);
        if ((le & 1) == 1) {
            prenum = (prenum >> 1) % mod;
            res = (res + (prenum * (le % mod) * 3) % mod) % mod;
        } else {
            prenum = prenum % mod;
            le = (le >> 1) % mod;
        }
        res = (res + 20 + (prenum * (le % mod) * 3) % mod) % mod;
        System.out.println(res);
    }
}
