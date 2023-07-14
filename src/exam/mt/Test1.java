package exam.mt;

import java.util.Scanner;

/**
 * @author ZhouHao
 * @version 1.0
 * @description TODO
 * @date 2023/3/11 18:57
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.length() == 1) {
            System.out.println(0);
            return;
        }
        int res = 0;
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                res++;
                chars[i] = '.';
            }
        }
        System.out.println(res);
    }
}
