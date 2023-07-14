package exam.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZhouHao
 * @version 1.0
 * @description TODO
 * @date 2023/3/11 19:42
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        // 流行出现时间
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
        }
        // 流行消失时间
        for (int i = 0; i < n; i++) {
            arr[i][1] = sc.nextInt();
        }
        // 将数组按照出现时间升序，消失时间升序
        Arrays.sort(arr, (int[] arr1, int[] arr2) -> {
            // 如果出现时间相等 按照消失时间升序，否则按照出现时间升序
            if (arr1[0] == arr2[0]) {
                return arr1[1] - arr2[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });

        /*
        -----
          ------
               -------
               1 3
               2 6
               5 7
        * */
        // 滑动窗口
        int max = 1;
        int left = 0;   // 窗口左边界
        int right = 0;  // 窗口右边界
        int timeL = arr[0][0];
        int timeR = arr[0][1];
        int res = 1;
        int count = timeR - timeL + 1;
        for (;right < arr.length; right++) {
            // 判断当前流星能不能和之前 流行组一起观看
            // 可以一起观看
            if (max == 0) {
                max = 1;
                timeL = arr[right][0];
                timeR = arr[right][1];
                continue;
            }
            if (arr[right][0] <= timeR) {
                max++;
                timeL = arr[right][0];
                timeR = Math.min(timeR, arr[right][1]);
                if (max > res) {
                    res = max;
                    count = timeR - timeL + 1;
                } else if (max == res) {
                    count += timeR - timeL + 1;
                }
            } else {
                // 窗口左边界右移
                if (timeR == arr[left][1]) {
                    timeR = arr[left + 1][1];
                }
                left++;
                max--;
            }
            right--;
        }

        System.out.print(res);
        System.out.print(" ");
        System.out.println(count);
    }
}
