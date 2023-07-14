package exam.xiecheng;

import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/3/6 20:24
 * @description: TODO
 * @version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 根据切的块数，求得单块面积
        float area = n * n;
        // 总块数
        int total = (k / 2 + 1) * (k - k / 2 + 1);
        System.out.println(area / total);
    }
}
