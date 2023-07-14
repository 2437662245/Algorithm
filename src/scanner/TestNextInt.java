package scanner;

import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/24 22:20
 * @description: 测试nextInt
 * @version: 1.0
 */

/*
数据范围: 数据组数 1 ≤ t ≤ 100 数据大小满足 1≤n≤1000
输入描述: 输入包括两个正整数a,b(1 <= a, b <= 1000),输入数据包括多组。
输出描述: 输出a+b的结果
*/
public class TestNextInt {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println(reader.nextInt());
        System.out.println("reader.nextLine() = " + reader.nextLine());
        System.out.println("reader.nextLine() = " + reader.nextLine());
        System.out.println("reader.nextInt() = " + reader.nextInt());
        System.out.println("reader.nextInt() = " + reader.nextInt());
        System.out.println("reader.nextInt() = " + reader.nextInt());
    }
}
