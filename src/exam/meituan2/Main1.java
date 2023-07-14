package exam.meituan2;

import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/3/18 12:27
 * @description: TODO
 * @version: 1.0
 */
/**
 * 小美在玩一项游戏。该游戏的目标是尽可能抓获敌人。
 * 敌人的位置将被一个二维坐标 (x, y) 所描述。
 * 小美有一个全屏技能，该技能能一次性将若干敌人一次性捕获。
 * 捕获的敌人之间的横坐标的最大差值不能大于A，纵坐标的最大差值不能大于B。
 * 现在给出所有敌人的坐标，你的任务是计算小美一次性最多能使用技能捕获多少敌人。
 * 输入描述
 * 第一行三个整数N,A,B，表示共有N个敌人，小美的全屏技能的参数A和参数B。
 * 接下来N行，每行两个数字x,y，描述一个敌人所在的坐标。
 * 1≤N≤500，1≤A,B≤1000，1≤x,y≤1000。
 *
 * 输出描述
 * 一行，一个整数表示小美使用技能单次所可以捕获的最多数量。
 * 样例输入
 * 3 1 1
 * 1 1
 * 1 2
 * 1 3
 * 样例输出
 * 2
 * 提示
 * 样例解释1
 * 最多可以同时捕获两名敌人，可以是(1, 1)和(1, 2)处的敌人，
 * 可以是(1, 2)和(1, 3)处的敌人，但不可以同时捕获三名敌人，
 * 因为三名敌人时，纵坐标的最大差值是2，超过了参数B的值1。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();	// 敌人数
        int A = sc.nextInt();	// 横坐标最大相差
        int B = sc.nextInt();	// 纵坐标最大相差
        // 用二维数组存敌人，先用List接收，找到敌人的最大横纵坐标
        int[][] arr = new int[N][2];
        int xMax = 0;
        int yMax = 0;
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            xMax = Math.max(xMax, arr[i][0]);
            arr[i][1] = sc.nextInt();
            yMax = Math.max(yMax, arr[i][1]);
        }
        // 建二维坐标系
        int[][] xys = new int[xMax][yMax];
        for (int[] a : arr) {
            xys[a[0] - 1][a[1] - 1] += 1;
        }
        // xys中存放了每个位置敌人数
        // 前缀和
        for (int i = 0; i < xys.length; i++) {
            for (int j = 1; j < xys[0].length; j++) {
                xys[i][j] += xys[i][j - 1];
            }
        }
        for (int i = 1; i < xys.length; i++) {
            for (int j = 0; j < xys[0].length; j++) {
                xys[i][j] += xys[i - 1][j];
            }
        }
        // xys前缀和数组
        // 遍历前缀和数组，找到最大的差
        int max = 0;

        for (int i = A; i < xys.length; i++) {
            for (int j = B; j < xys[0].length; j++) {
                max = Math.max(max, xys[i][j] - xys[i - A][j - B]);
            }
        }
        System.out.println(max);
    }
}

