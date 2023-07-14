package scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/28 11:54
 * @description: TODO
 * @version: 1.0
 */
/*
时间限制： 3000MS
内存限制： 589824KB
题目描述：
作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。
手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。
请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个串珠中出现了至少两次。

输入描述
第一行输入n，m，c三个数，用空格隔开。
(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50) 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。
接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)

输出描述
一个非负整数，表示该手链上有多少种颜色不符需求

样例输入
5 2 3
3 1 2 3
0
2 2 3
1 2
1 3
样例输出
2

*/
import java.util.Scanner;
public class ZJ01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.valueOf(str.charAt(0)); // 5个杂色串珠
        int m = Integer.valueOf(str.charAt(2)); // 一种颜色在任意连续m=2个中最多出现1次 ，环形
        int c = Integer.valueOf(str.charAt(4)); // 串珠颜色共c=3种
        while (sc.hasNextLine()) {
            // 读到的一个珠子的信息 当前珠子有多少颜色 当前珠子包含的颜色有哪几几种
            String[] strs = sc.nextLine().split(" ");

        }
    }
}