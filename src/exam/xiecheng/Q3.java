package exam.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/3/7 14:30
 * @description: TODO
 * @version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读组数t
        int t = sc.nextInt();
        // 存结果
        int[] res = new int[t];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < t; i++) {
            // 数组长度
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int rMax = 0;
            int rMin = Integer.MAX_VALUE;
            int bMax = 0;
            int bMin = Integer.MAX_VALUE;
            // 寻找红蓝色的最大最小值
            sc.nextLine();
            // str是红蓝字符串
            String str = sc.nextLine();
            for (int k = 0; k < n; k++) {
                if (str.charAt(k) == 'R') {
                    rMax = Math.max(rMax, arr[k]);
                    rMin = Math.min(rMin, arr[k]);
                } else {
                    bMax = Math.max(bMax, arr[k]);
                    bMin = Math.min(bMin, arr[k]);
                }
            }
            // 找到了红蓝部分各自的最大最小值
            if (rMax > bMax) {
                // 红色最大值大
                // 蓝色最大值增大到和红色一样大
                bMin += rMax - bMax;
                res[i] = Math.min(res[i], rMax - Math.min(rMin, bMin));
            } else if (rMax == bMax) {
                // 红蓝最大值一样大
                res[i] = Math.min(res[i], rMax - Math.min(rMin, bMin));
            } else {
                // 蓝色最大值大 红色最大值增大，最小值跟着增大
                rMin += bMax - rMax;
                res[i] = Math.min(res[i], bMax - Math.min(rMin, bMin));
            }
        }
        for (int i : res) {
            System.out.println(i);
        }
    }
}
