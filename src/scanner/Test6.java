package scanner;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/25 20:58
 * @description: TODO
 * @version: 1.0
 */
public class Test6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            int n = Integer.valueOf(strs[0]);
            int sum = 0;
            for (int i = 1; i < strs.length; i++) {
                sum += Integer.valueOf(strs[i]);
            }
            System.out.println(sum);
        }
    }
}
