package scanner;

import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/24 22:24
 * @description: TODO
 * @version: 1.0
 *
 */
/*
数据范围: 数据组数 1 ≤ t ≤ 100 数据大小满足 1≤n≤1000
输入描述:
    输入第一行包括一个数据组数t(1 <= t <= 100)
    接下来每行包括两个正整数a,b(1 <= a, b <= 1000)
输出描述: 输出a+b的结果
*/
public class Test2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        /*
        实现方式1：
        int t = reader.nextInt();
        for (int i = 0; i < t; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            System.out.println(a + b);
        }*/

        // 实现方式2
        int t = Integer.valueOf(reader.nextLine());
        // int t = reader.nextInt(); 报错
        for (int i = 0; i < t; i++) {
            String[] strs = reader.nextLine().split(" ");
            System.out.println(Integer.valueOf(strs[0]) + Integer.valueOf(strs[1]));
        }

        reader.close();
    }
}
