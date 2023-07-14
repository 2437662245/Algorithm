package scanner;

import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/24 22:42
 * @description: TODO
 * @version: 1.0
 */
/*
数据范围: 数据组数 1 ≤ t ≤ 100 数据大小满足 1 ≤ n ≤ 100
输入描述: 输入包括两个正整a,b数(1 <= a, b <= 10^9), 输入数据有多组, 如果输入为0 0则结束输入
输出描述: 输出a+b的结果
*/


public class Test3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            if (a == 0 && b == 0) {
                return;
            } else {
                System.out.println(a + b);
            }
        }
    }
}
