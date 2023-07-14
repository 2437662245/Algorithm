package scanner;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/25 21:15
 * @description: TODO
 * @version: 1.0
 */
public class Test7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
        String[] strs = reader.nextLine().split(" ");
        Arrays.sort(strs, (a, b) -> {
            char[] charA = a.toCharArray();
            char[] charB = b.toCharArray();
            for (int i = 0; i < charA.length; i++) {
                if (charA.length == i) {
                    return -1;
                } else if (charB.length == i) {
                    return 1;
                } else if (charA[i] < charB[i]){
                    return -1;
                } else {
                    return 1;
                }
            }
            return 1;
        });
        for (String str : strs) {
            System.out.print(str);
            System.out.print(" ");
        }
    }
}
