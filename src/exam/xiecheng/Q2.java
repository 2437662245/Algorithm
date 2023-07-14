package exam.xiecheng;

import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/3/6 20:40
 * @description: TODO
 * @version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] strs1 = sc.nextLine().split(" ");
            String[] strs2 = sc.nextLine().split(" ");
            String[] strs3 = sc.nextLine().split(" ");
            String[] strs4 = sc.nextLine().split(" ");
            int oneCount1 = 0;
            int oneCount2 = 0;
            int[][] arr1 = new int[][]{{Integer.valueOf(strs1[0]),
                                        Integer.valueOf(strs1[1])},
                                       {Integer.valueOf(strs2[0]),
                                        Integer.valueOf(strs2[1])}};
            int[][] arr2 = new int[][]{{Integer.valueOf(strs3[0]),
                                        Integer.valueOf(strs3[1])},
                                        {Integer.valueOf(strs4[0]),
                                        Integer.valueOf(strs4[1])}};
            for (int[] arr : arr1) {
                for (int i : arr) {
                    if (i == 1) {
                        oneCount1++;
                    }
                }
            }
            for (int[] arr : arr2) {
                for (int i : arr) {
                    if (i == 1) {
                        oneCount2++;
                    }
                }
            }
            if (oneCount1 != oneCount2) {
                System.out.print(-1 + " ");
            }
            // 矩阵中1个1
            if (oneCount1 == 1) {
                for (int i = 0; i < arr1.length; i++) {
                    for (int j = 0; j < arr1[i].length; j++) {
                        if (arr1[i][j] == 1) {
                            if (arr2[i][j] == 1) {
                                System.out.print(0 + " ");
                            } else if (arr2[Math.abs(i - 1)][Math.abs(j - 1)] == 1) {
                                System.out.print(2 + " ");
                            } else {
                                System.out.print(1 + " ");
                            }

                        }
                    }
                }
            }
            // 矩阵中3个1
            if (oneCount1 == 3) {
                for (int i = 0; i < arr1.length; i++) {
                    for (int j = 0; j < arr1[i].length; j++) {
                        if (arr1[i][j] == 0) {
                            if (arr2[i][j] == 0) {
                                System.out.print(0 + " ");
                            } else if (arr2[Math.abs(i - 1)][Math.abs(j - 1)] == 0) {
                                System.out.print(2 + " ");
                            } else {
                                System.out.print(1 + " ");
                            }

                        }
                    }
                }
            }
            // 矩阵中2个1
            if (oneCount1 == 2) {
                if (arr1[0][0] == arr2[0][0] && arr1[1][1] == arr2[1][1]) {
                    System.out.print(0 + " ");
                } else if (arr1[0][0] != arr2[0][0] && arr1[1][1] != arr2[1][1]) {
                    System.out.print(2 + " ");
                } else {
                    System.out.print(1 + " ");
                }
            }
        }
    }
}
